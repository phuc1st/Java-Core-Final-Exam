import service.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager service = new StudentManager();
        Scanner sc = new Scanner(System.in);

        //Đọc dữ liệu từ file
        service.readData("goodStudent.csv", "Good");
        service.readData("normalStudent.csv", "Normal");


        int n = 0;
        do{
            try {
                System.out.print("Nhập số lượng cần tuyển (11 - 15): ");
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }while (n<11 || n>15);

        //Thực hiện tuyển dụng
        service.recruit(n);

        //Hiển thị tất cả sinh viên
        service.displayAllSorted();

        System.out.print("--- KẾT THÚC CHƯƠNG TRÌNH ---");
    }
}