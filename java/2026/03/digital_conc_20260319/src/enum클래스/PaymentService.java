package enum클래스;

public class PaymentService {

    public void process(String method, long amount){
        // 문제점 1: 상수의 개수가 추가될때마다 추가해줘야함
        if(!method.equals(PaymentConstants.CARD) && !method.equals(PaymentConstants.CASH) && !method.equals(PaymentConstants.POINT)){
            System.out.println("[에러] 잘못된 결제 방식입니다.");
            return;
        }

        if(method.equals(PaymentConstants.CARD)){
            System.out.println("카드로 " + amount + "원 결제합니다. (수수료 3%)");
        }else if(method.equals(PaymentConstants.CASH)){
            System.out.println("현금으로 " + amount + "원 결제합니다. (수수료 0%)");
        }else{
            System.out.println("포인트로 " + amount + "원 결제합니다. (수수료 0.01%)");
        }


    }
    // 문제점 1 : 타입 안정성 부족
    public long calculateFee(String method, long amount){
        // 문제점 2 : 로직이 여기저기 흩어짐
        if(method.equals(PaymentConstants.CARD)){
            return (long)(amount * 0.03);
        }else if(method.equals(PaymentConstants.CASH)){
            return 0;
        }else if(method.equals(PaymentConstants.POINT)){
            return (long) (amount * 0.01);
        }else{
            // 문제점 3: 정의되지 않는 값이 들어왔을 떄의 예외 처리를 매번 직접 해줭야함
            throw new IllegalArgumentException ("지원하지 않는 결제 수단입니다: " + method);
        }
    }
}
