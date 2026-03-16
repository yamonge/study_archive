package 은행ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        ArrayList<NewBank> banks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1.계좌 계설 2. 예금 3. 출금 4. 정보 보기 5.전체 계좌 개수 조회 6. 종료");
            System.out.print("선택: ");
            int choice;
            // TODO : 숫자만 입력받기 음수, 문자열 X
            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println("잘못된 선택입니다. 1에서 6 사이의 숫자를 입력해주세요.");
                    continue; // 다시 선택으로 돌아가기
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next(); // 잘못된 입력을 버퍼에서 제거
                continue; // 다시 선택으로 돌아가기
            }
            switch (choice) {
                case 1: //회원가입
                    System.out.print("은행 이름을 입력하세요: ");
                    String bankName = sc.next();
                    System.out.print("예금주 이름을 입력하세요: ");
                    String userName = sc.next();
                    System.out.print("초기 입금 금액을 입력하세요: ");
                    int initialDeposit = sc.nextInt();
                    banks.add(new NewBank(bankName, userName, initialDeposit));
                    break;
                case 2: //로그인
                    if(banks.isEmpty()){
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("계좌번호를 입력해주세요: ");
                    String depositAccountNumber = sc.next();
                    System.out.print("예금할 금액을 입력하세요: ");
                    int depositAmount = sc.nextInt();
                    boolean foundDeposit = false;
                    for (NewBank b : banks) {
                        if (b.getAccountNumber().equals(depositAccountNumber)) {
                            b.deposit(depositAmount);
                            foundDeposit = true;
                            break;
                        }else{
                            System.out.println("해당 계좌번호가 존재하지 않습니다.");
                        }
                    }
                    break;
                case 3:
                    if(banks.isEmpty()){
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("계좌번호를 입력해주세요: ");
                    String withdrawAccountNumber = sc.next();
                    System.out.print("출금할 금액을 입력하세요: ");
                    int withdrawAmount = sc.nextInt();
                    boolean foundWithdraw = false;
                    for (NewBank b : banks) {
                        if (b.getAccountNumber().equals(withdrawAccountNumber)) {
                            b.withdraw(withdrawAmount);
                            foundWithdraw = true;
                            break;
                        }else{
                            System.out.println("해당 계좌번호가 존재하지 않습니다.");
                        }
                    }
                    break;
                case 4:
                    if(banks.isEmpty()) {
                        System.out.println("계좌가 존재하지 않습니다. 계좌를 개설해주세요.");
                        break;
                    }
                    System.out.print("잔액을 확인할 계좌번호를 입력하세요: ");
                    String infoAccountNumber = sc.next();
                    boolean foundInfo = false;
                    for (NewBank b : banks) {
                        if (b.getAccountNumber().equals(infoAccountNumber)) {
                            b.showInfo();
                            foundInfo = true;
                            break;
                        } else {
                            System.out.println("해당 계좌번호가 존재하지 않습니다.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("전체 계좌 개수: " + NewBank.getCount());
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
