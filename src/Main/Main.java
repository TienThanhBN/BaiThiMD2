package Main;

import Contronller.ContactManager;
import Model.Contact;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("------Chương Trình Quản Lý Danh Bạ-------");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.showContacts();
                    break;
                case 2:

                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    if (!manager.isPhoneNumberValid(phoneNumber)) {
                        System.out.println("Số điện thoại không hợp lệ.");
                        break;
                    }

                    System.out.print("Nhập nhóm: ");
                    String group = scanner.nextLine();
                    System.out.print("Nhập họ tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    if (!manager.isEmailValid(email)) {
                        System.out.println("Email không hợp lệ.");
                        break;
                    }

                    manager.addContact(phoneNumber, group, name, gender, address, birthDate, email);
                    break;
                case 3:
                    // Cập nhật thông tin danh bạ
                    System.out.print("Nhập số điện thoại cần cập nhật: ");
                    String updatePhone = scanner.nextLine();
                    Contact contact = manager.searchContactByPhoneNumber(updatePhone);
                    if (contact != null) {
                        System.out.println("Thông tin hiện tại: " + contact);
                        System.out.print("Nhập nhóm mới: ");
                        String newGroup = scanner.nextLine();
                        System.out.print("Nhập họ tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập giới tính mới: ");
                        String newGender = scanner.nextLine();
                        System.out.print("Nhập địa chỉ mới: ");
                        String newAddress = scanner.nextLine();
                        System.out.print("Nhập ngày sinh mới: ");
                        String newBirthDate = scanner.nextLine();
                        System.out.print("Nhập email mới: ");
                        String newEmail = scanner.nextLine();
                        manager.updateContact(updatePhone, newGroup, newName, newGender, newAddress, newBirthDate, newEmail);
                    } else {
                        System.out.println("Không tìm thấy danh bạ với số điện thoại trên.");
                    }
                    break;
                case 4:

                    System.out.print("Nhập số điện thoại cần xóa: ");
                    String deletePhone = scanner.nextLine();
                    manager.deleteContact(deletePhone);
                    break;
                case 5:

                    System.out.print("Nhập số điện thoại cần tìm: ");
                    String searchPhone = scanner.nextLine();
                    Contact searchContact = manager.searchContactByPhoneNumber(searchPhone);
                    if (searchContact != null) {
                        System.out.println("Thông tin danh bạ: " + searchContact);
                    } else {
                        System.out.println("Không tìm thấy danh bạ.");
                    }
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
