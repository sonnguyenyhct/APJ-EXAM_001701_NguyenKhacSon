package model;

public class PhoneBook {
    private int id;
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDay;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(int id,String phoneNumber, String group, String fullName, Boolean gender, String address, String birthDay, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = setGender(gender);
        this.address = address;
        this.id = id;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public String setGender(boolean gender) {
        if (gender){
            this.gender = "Nam";
        }else {
            this.gender = "Nữ";
        }
        return this.gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
