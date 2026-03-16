package 은행만들기;
    // 정적맴버(필드)
    // 정적메서드
public class Bank {
    private static int count = 0;
    private int account; // 인스턴스 필드
    private String bank;

    public Bank(String bank, int account){
        this.bank = bank;
        this.account = account;
        count++;
        System.out.println(bank + "은행에 계좌를 개설 합니다." + "잔액은" + account + "입니다.");
    }

    public static int getCount(){
        return count;
    }

    //예금 기능 구현: 매게 변수로 값을 전달 받아 account에 누적
    public static void deposit(Bank b, final int amount){
        b.account += amount;
        System.out.println(amount + "원 입금이 완료되었습니다.");
    }
    // 출금 기능 구현: 매개 변수로 값을 전달 받아 account의 값을 착람하는 기능 구현
    public static void withdraw(Bank b, final int amount){
        int comp = b.account - amount;
        if(comp < 0){
            System.out.println(b.bank + "의 잔액이 부족합니다.");
        }else{
            b.account -= amount;
            System.out.println(amount + "원 출금이 완료되었습니다.");
        }
    }
    // 잔액보기 기능 구현(은행이름과 현재의 잔액을 보여줌)
    public static void showInfo(Bank b){
        System.out.printf("은행 이름: %s\n", b.bank);
        System.out.printf("보유 잔액: %d\n", b.account);
    }

    public static String getBankName(Bank b){
        return b.bank;
    }
}
