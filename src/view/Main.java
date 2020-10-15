package view;

import controller.PhoneBookController;
import model.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<PhoneBook> phoneBooks;


    public static void main(String[] args) {
        phoneBooks = new ArrayList<>();
        PhoneBookController phoneBookController = new PhoneBookController(phoneBooks);
        while (true){
            Main.menu(phoneBookController);
        }
    }

    private static void menu(PhoneBookController phoneBookController){
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số để tiếp tục");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");

        int choice = new Scanner(System.in).nextInt();

        switch (choice){
            case 1 :
                phoneBookController.displayPhoneBook();
                break;
            case 2 :
                phoneBookController.addPhoneBook();
                break;
            case 3 :
                phoneBookController.updateBookPhone();
                break;
            case 4 :
                phoneBookController.deleleBookPhone();
                break;
            case 5 :
                phoneBookController.findBookPhone();
                break;
            case 6 :
                phoneBooks = PhoneBookController.readFile();
                break;
            case 7 :
                phoneBookController.writeFile();
                break;
            case 8 :
                System.exit(0);
                break;
        }
    }

}
