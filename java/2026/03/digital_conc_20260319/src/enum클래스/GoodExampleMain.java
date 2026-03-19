package enum클래스;

import java.util.Scanner;

public class GoodExampleMain {
    public static void main(String[] args) {
        NewPaymentService service = new NewPaymentService();
//        long cardFee2 = service.calculateFee(PaymentType.MONEY, 10000);
//        long cardFee = service.calculateFee(PaymentType.CARD, 10000);
//        System.out.println(PaymentType.CARD.getTitle() + " 수수료: " + cardFee);

        Scanner sc = new Scanner(System.in);
        PaymentType val = null;
        while(true){
            System.out.print("결제 수단을 입력하세요. (CARD, CASH, POINT): ");
            String input = sc.nextLine();
            try{
                val = PaymentType.fromInput(input);
                System.out.println(service.calculateFee(val, 10000));
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[오류] : " + e.getMessage());
            }
        }
    }
}
