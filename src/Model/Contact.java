package Model;

public class Contact {
    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    public Contact(String phoneNumber, String group, String name, String gender, String address, String birthDate, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Số điện thoại: " + phoneNumber + ", Nhóm: " + group + ", Họ tên: " + name + ", Giới tính: " + gender +
                ", Địa chỉ: " + address + ", Ngày sinh: " + birthDate + ", Email: " + email;
    }
}
