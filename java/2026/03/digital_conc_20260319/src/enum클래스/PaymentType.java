package enum클래스;

public enum PaymentType {
    CARD("신용카드", 0.03),
    CASH("현금", 0.0),
    POINT("포인트", 0.01);

    private final String title;
    private final double feeRate;

    PaymentType(String title, double feeRate){
        this.title = title;
        this.feeRate = feeRate;
    }

    public static  PaymentType fromInput(String input){
        try{
            return PaymentType.valueOf(input);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("지원하지 않는 결제 수단입니다: " + input);
        }
    }

    public String getTitle(){
        return title;
    }

    public long calculater(long amount){
        return (long) (amount * feeRate);
    }
}
