package enum클래스;

public class NewPaymentService {
    public long calculateFee(PaymentType type, long amount){
        return type.calculater(amount);
    }
}
