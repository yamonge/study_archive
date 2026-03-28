package 예외실습;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 입금 2. 출금 3. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    System.out.print("입금할 금액 입력: ");
                    int amount = sc.nextInt();
                    account.deposit(amount);
                    System.out.println("현재 잔액: " + account.getBalance());
                } else if (choice == 2) {
                    System.out.print("출금할 금액 입력: ");
                    int amount = sc.nextInt();
                    account.withdraw(amount);
                    System.out.println("현재 잔액: " + account.getBalance());
                } else if (choice == 3) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 선택입니다.");
                }
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
