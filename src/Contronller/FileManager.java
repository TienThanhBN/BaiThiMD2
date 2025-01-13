package Contronller;

import Model.Contact;

import java.io.*;
import java.util.*;

public class FileManager {

    public static List<Contact> readFromFile(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    String phoneNumber = data[0];
                    String group = data[1];
                    String name = data[2];
                    String gender = data[3];
                    String address = data[4];
                    String birthDate = data[5];
                    String email = data[6];
                    contacts.add(new Contact(phoneNumber, group, name, gender, address, birthDate, email));
                }
            }
        } catch (IOException e) {
            System.out.println("Đọc file thất bại: " + e.getMessage());
        }
        return contacts;
    }

    public static void writeToFile(String fileName, List<Contact> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                String line = String.join(",", contact.getPhoneNumber(), contact.getGroup(), contact.getName(), contact.getGender(),
                        contact.getAddress(), contact.getBirthDate(), contact.getEmail());
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Đã ghi danh bạ vào file thành công.");
        } catch (IOException e) {
            System.out.println("Ghi file thất bại: " + e.getMessage());
        }
    }
}
