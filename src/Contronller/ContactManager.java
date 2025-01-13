package Contronller;

import Model.Contact;

import java.util.*;
import java.util.regex.*;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String phoneNumber, String group, String name, String gender, String address, String birthDate, String email) {
        contacts.add(new Contact(phoneNumber, group, name, gender, address, birthDate, email));
        System.out.println("Đã thêm danh bạ thành công.");
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ rỗng.");
        } else {
            int count = 0;
            for (Contact contact : contacts) {
                System.out.println(contact);
                count++;
                if (count % 5 == 0) {
                    System.out.println("Nhấn Enter để tiếp tục hiển thị...");
                    new Scanner(System.in).nextLine();
                }
            }
        }
    }

    public void updateContact(String phoneNumber, String newGroup, String newName, String newGender, String newAddress, String newBirthDate, String newEmail) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contact = new Contact(phoneNumber, newGroup, newName, newGender, newAddress, newBirthDate, newEmail);
                System.out.println("Cập nhật thông tin thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy danh bạ với số điện thoại trên.");
    }

    public Contact searchContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void deleteContact(String phoneNumber) {
        contacts.removeIf(contact -> contact.getPhoneNumber().equals(phoneNumber));
        System.out.println("Danh bạ đã được xóa.");
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
