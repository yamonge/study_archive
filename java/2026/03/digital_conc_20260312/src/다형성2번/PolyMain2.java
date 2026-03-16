package 다형성2번;

import java.util.Scanner;

public class PolyMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Driver driver = new Driver("홍길동");
        ExceptionClass ex = new ExceptionClass();
        while(true) {
            System.out.println("1. 버스");
            System.out.println("2. 택시");
            System.out.println("3. 스포츠카");
            System.out.println("4. 종료");
            System.out.print("운전할 차량을 선택하세요: ");
            String number = sc.nextLine();
            int menu = ex.number(number, 4);
            switch (menu) {
                case 1:
                    driver.drive(new Bus(), 50);
                    break;
                case 2:
                    driver.drive(new Taxi(), 90);
                    break;
                case 3:
                    driver.drive(new SportCar(), 120);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:

            }
        }
    }
}
