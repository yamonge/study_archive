package 실습예제;

import java.util.Scanner;

public class DeliveryMain {
    public static void main(String[] args) {
        Manager mg = new Manager();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. 일반 택배");
            System.out.println("2. 퀵 서비스");
            System.out.println("3. 항공 배송");
            System.out.println("4. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    mg.send(new ParcelDelivery());
                    break;
                case 2:
                    mg.send(new QuickDelivery());
                    break;
                case 3:
                    mg.send(new AirDelivery());
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}
