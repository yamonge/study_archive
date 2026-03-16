package 은행만들기;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Bank> banks = new ArrayList<>();
        while (true) {
            System.out.println("\n1.계좌 계설 2. 예금 3. 출금 4. 잔액 보기 5.전체 계좌 개수 조회 6. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("은행 이름을 입력하세요: ");
                    String bankName = sc.next();
                    System.out.print("초기 입금 금액을 입력하세요: ");
                    int initialDeposit = sc.nextInt();
                    banks.add(new Bank(bankName, initialDeposit));
                    break;
                case 2:
                    if(banks.isEmpty()){
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("예금할 은행 이름을 입력하세요: ");
                    String depositBankName = sc.next();
                    System.out.print("예금할 금액을 입력하세요: ");
                    int depositAmount = sc.nextInt();
                    for (Bank b : banks) {
                        String currentBankName = Bank.getBankName(b);
                        if (currentBankName.equals(depositBankName)) {
                            Bank.deposit(b, depositAmount);
                            break;
                        }else{
                            System.out.println("해당 은행이 존재하지 않습니다.");
                        }
                    }
                    break;
                case 3:
                    if(banks.isEmpty()){
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("출금할 은행 이름을 입력하세요: ");
                    String withdrawBankName = sc.next();
                    System.out.print("출금할 금액을 입력하세요: ");
                    int withdrawAmount = sc.nextInt();
                    for (Bank b : banks) {
                        String currentBankName = Bank.getBankName(b);
                        if (currentBankName.equals(withdrawBankName)) {
                            Bank.withdraw(b, withdrawAmount);
                            break;
                        }else{
                            System.out.println("해당 은행이 존재하지 않습니다.");
                        }
                    }
                    break;
                case 4:
                    if(banks.isEmpty()) {
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("잔액을 확인할 은행의 이름을 입력하세요: ");
                    String infoBankName = sc.next();
                    for (Bank b : banks) {
                        String currentBankName = Bank.getBankName(b);
                        if (currentBankName.equals(infoBankName)) {
                            Bank.showInfo(b);
                            break;
                        } else {
                            System.out.println("해당 은행이 존재하지 않습니다.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("전체 계좌 개수: " + Bank.getCount());
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }
    }
}
