package 예외실습;

public class InsufficientBalanceException extends Exception {
    private int balance;
    private int withdrawAmount;

    public InsufficientBalanceException(int balance, int withdrawAmount) {
        super("잔액이 부족합니다. 현재 잔액: " + balance + ", 출금 요청 금액: " + withdrawAmount);
        this.balance = balance;
        this.withdrawAmount = withdrawAmount;
    }

    public int getBalance() {
        return balance;
    }

    public int getWithdrawAmount() {
        return withdrawAmount;
    }
}
