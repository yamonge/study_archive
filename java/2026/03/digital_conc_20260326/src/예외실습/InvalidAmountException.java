package 예외실습;

public class InvalidAmountException extends Exception{
    private int amount;

    public InvalidAmountException(int amount) {
        super("[오류] 입금/출금 금액은 0보다 커야합니다. 입력값: " + amount);
        this.amount = amount;
    }
}
