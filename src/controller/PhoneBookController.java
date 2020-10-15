package controller;

import check.Check;
import model.PhoneBook;
import storage.File;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookController {
    private static final String PHONEBOOK_FILE = "contacts.csv";
    Check check = new Check();
    ArrayList<PhoneBook> phoneBookList;
    Scanner scanner = new Scanner(System.in);

    public PhoneBookController(ArrayList<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public void displayPhoneBook(){
        System.out.printf("%s%20s%20s%20s%20s%20s%n","ID","Nhóm","Họ tên","Giới tính","Địa chỉ","Số điện thoại");
        for (int i = 0; i < phoneBookList.size(); i++){
            System.out.printf("%d%20s%17s%25s%20s%20s%n",phoneBookList.get(i).getId(),phoneBookList.get(i).getGroup(),phoneBookList.get(i).getFullName(),phoneBookList.get(i).getGender(),phoneBookList.get(i).getAddress(),phoneBookList.get(i).getPhoneNumber());
        }
    }
    public void addPhoneBook(){
        int id;
        if (phoneBookList.size() == 0){
            id = 1;
        }else {
            id = phoneBookList.get(phoneBookList.size() - 1).getId() + 1;
        }
        System.out.println("Nhập vào nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập vào họ tên");
        String name = scanner.nextLine();
        boolean gender;
        while (true){
            System.out.println("Chọn giới tính : 1. Nam 2. Nữ");
            int genderInt = scanner.nextInt();
            if (genderInt == 1){
                gender = true;
                break;
            }else if (genderInt == 2){
                gender = false;
                break;
            }else {
                System.out.println("Chọn lại giới tính");
            }
        }
        System.out.println("Nhập vào địa chỉ");
        String address = new Scanner(System.in).nextLine();
        String phoneNumber;
        while (true){
            System.out.println("Nhập vào số điện thoại");
             phoneNumber = new Scanner(System.in).nextLine();
            if (!check.checkPhone(phoneNumber)){
                System.out.println("Nhập sai số điện thoại, nhập lại");
            }else {
                break;
            }
        }
        System.out.println("Nhập vào ngày sinh");
        String birthDay = new Scanner(System.in).nextLine();

        String email;
        while (true){
            System.out.println("Nhập vào email");
            email = new Scanner(System.in).nextLine();
            if (!check.checkEmail(email)){
                System.out.println("Nhập sai email, nhập lại");
            }else {
                break;
            }
        }
        if (!check.checkEmail(email)){
            System.out.println("Nhập sai email, nhập lại");
        }

        phoneBookList.add(new PhoneBook(id,phoneNumber,group,name,gender,address,birthDay,email));
    }

    public void updateBookPhone(){
        boolean check = true;
        while (check){
            System.out.println("Nhập vào số điện thoại cần sửa");
            String number = scanner.nextLine();
            if (number.equals("")){
                break;
            }
            for (PhoneBook phoneBook : phoneBookList){
                if (number.equals(phoneBook.getPhoneNumber())){
                    check = false;
                    System.out.println("Nhập vào nhóm mới");
                    String group = scanner.nextLine();
                    System.out.println("Nhập vào họ tên mới");
                    String name = scanner.nextLine();
                    boolean gender;
                    while (true){
                        System.out.println("Chọn giới tính mới : 1. Nam 2. Nữ");
                        int genderInt = scanner.nextInt();
                        if (genderInt == 1){
                            gender = true;
                            break;
                        }else if (genderInt == 2){
                            gender = false;
                            break;
                        }else {
                            System.out.println("Chọn lại giới tính mới");
                        }
                    }
                    System.out.println("Nhập vào địa chỉ mới");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println("Nhập vào ngày sinh mới");
                    String birthDay = new Scanner(System.in).nextLine();
                    System.out.println("Nhập vào email mới");
                    String email = new Scanner(System.in).nextLine();
                    phoneBook.setAddress(address);
                    phoneBook.setBirthDay(birthDay);
                    phoneBook.setEmail(email);
                    phoneBook.setFullName(name);
                    phoneBook.setGroup(group);
                    phoneBook.setGender(gender);
                    System.out.println("Sửa thành công");
                }
            }
            if (check){
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
        }
    }
    public void deleleBookPhone(){
        boolean check = true;
        boolean checkDelete = true;
        while (check){
            System.out.println("Nhập vào số điện thoại cần xoá");
            String number = new Scanner(System.in).nextLine();
            if (number.equals("")){
                break;
            }
            for (PhoneBook phoneBook : phoneBookList){
                if (number.equals(phoneBook.getPhoneNumber())){
                    check = false;
                    System.out.println("Xác nhận muốn xoá : nhập Y để xoá");
                    String confirm = new Scanner(System.in).nextLine();
                    if (confirm.equals("y")){
                        phoneBookList.remove(phoneBook);
                        System.out.println("Xoá thành công");
                    }else {
                        checkDelete = false;
                    }
                }
            }
            if (check){
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
            if (!checkDelete){
                break;
            }
        }
    }
    public void findBookPhone(){
        System.out.println("Tìm theo tên nhập 1 - Tìm theo số điện thoại nhập 2");
        int input = new Scanner(System.in).nextInt();
        boolean check = false;
        if (input == 1){
            System.out.println("Nhập vào tên muốn tìm");
            String name = new Scanner(System.in).nextLine();

            for (PhoneBook phoneBook : phoneBookList) {
                if (phoneBook.getFullName().contains(name)) {
                    System.out.printf("%d%20s%17s%25s%20s%20s%n",phoneBook.getId(),phoneBook.getGroup(),phoneBook.getFullName(),phoneBook.getGender(),phoneBook.getAddress(),phoneBook.getPhoneNumber());
                    check = true;
                }
            }
            if (!check){
                System.out.println("Không tìm thấy tên");
            }
        }else if (input == 2){
            System.out.println("Nhập vào số điện thoại muốn tìm");
            String phoneNumber = new Scanner(System.in).nextLine();
            for (PhoneBook phoneBook : phoneBookList) {
                if (phoneBook.getPhoneNumber().contains(phoneNumber)) {
                    System.out.printf("%d%20s%17s%25s%20s%20s%n",phoneBook.getId(),phoneBook.getGroup(),phoneBook.getFullName(),phoneBook.getGender(),phoneBook.getAddress(),phoneBook.getPhoneNumber());
                    check = true;
                }
            }
            if (!check){
                System.out.println("Không tìm thấy số điện thoại");
            }
        }

    }
    public void writeFile(){
        File.writeFile(PHONEBOOK_FILE, phoneBookList);
        System.out.println("Ghi thành công.");
    }

    public static ArrayList<PhoneBook> readFile(){
        return (ArrayList<PhoneBook>) File.readFile(PHONEBOOK_FILE);
    }

}
