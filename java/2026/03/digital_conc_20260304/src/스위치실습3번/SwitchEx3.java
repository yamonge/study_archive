package 스위치실습3번;

import java.util.Scanner;

public class SwitchEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("자판기에 오신걸 환영합니다!");
        System.out.println("================================");
        System.out.printf("1. 콜라\t\t %s %5s원\n", "-", "1,500");
        System.out.printf("2. 사이다\t %s %5s원\n", "-", "1,500");
        System.out.printf("3. 커피\t\t %s %5s원\n", "-", "1,000");
        System.out.printf("4. 생수\t\t %s %5s원\n", "-", "500");
        System.out.println("================================");

        while(true) {
            System.out.print("투입 금액 입력: ");
            int money = sc.nextInt();
            System.out.print("메뉴 번호 선택: ");
            int menuNum = sc.nextInt();
            String menu = "";
            int menuPrice = 0;
            int total = 0;
            boolean isMenu = true;
            switch (menuNum) {
                case 1:
                    total = money - 1500;
                    menuPrice = 1500;
                    menu = "콜라";
                    break;
                case 2:
                    total = money - 1500;
                    menuPrice = 1500;
                    menu = "사이다";
                    break;
                case 3:
                    total = money - 1000;
                    menuPrice = 1000;
                    menu = "커피";
                    break;
                case 4:
                    total = money - 500;
                    menuPrice = 500;
                    menu = "생수";
                    break;
                default:
                    System.out.println("❌ 없는 메뉴입니다.");
                    isMenu = false;
            }

            if (total < 0 && isMenu) {
                System.out.println("================================");
                System.out.printf("❌ 잔액이 부족합니다.\n");
                System.out.printf("투입 금액 : %d원\n", money);
                System.out.printf("상품 금액 : %d원\n", menuPrice);
                System.out.printf("부족금액  : %d원\n", menuPrice - money);
                System.out.println("================================");
                continue;
            } else if (total >= 0 && isMenu) {
                System.out.println("================================");
                System.out.printf("✅ %s 가 나왔습니다!\n", menu);
                System.out.printf("투입 금액 : %d원\n", money);
                System.out.printf("상품 금액 : %d원\n", menuPrice);
                System.out.printf("거스름돈  : %d원\n", money - menuPrice);
                System.out.println("================================");
                break;
            }
        }
    }
}
