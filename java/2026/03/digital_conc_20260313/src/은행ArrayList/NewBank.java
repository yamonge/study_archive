package 은행ArrayList;

public class NewBank {
    private static int count = 0;
    private final String accountNumber;
    private int account;
    private String bankName;
    private String userName;

    public NewBank(String bankName, String userName, int account){
        this.bankName = bankName;
        this.userName = userName;
        this.account = account;
        count++;
        accountNumber = String.format("%03d-%02d-%04d", count, (int)(Math.random() * 100), (int)(Math.random() * 10000));
        System.out.println(bankName + "은행에 계좌를 개설 합니다." + "잔액은" + account + "입니다.");
        System.out.println("계좌 번호는 " + accountNumber + "입니다.");
    }

    public static int getCount(){
        return count;
    }

    public void deposit(final int amount){
        account += amount;
        System.out.println(amount + "원 입금이 완료되었습니다.");
    }

    public void withdraw(final int amount){
        int comp = account - amount;
        if(comp < 0){
            System.out.println(bankName + "의 잔액이 부족합니다.");
        }else{
            account -= amount;
            System.out.println(amount + "원 출금이 완료되었습니다.");
        }
    }

    public void showInfo(){
        System.out.printf("은행 이름: %s\n", bankName);
        System.out.printf("계좌 번호: %s\n", accountNumber);
        System.out.printf("예금주 이름: %s\n", userName);
        System.out.printf("보유 잔액: %d\n", account);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
