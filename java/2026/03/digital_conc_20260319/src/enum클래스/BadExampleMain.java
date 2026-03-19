package enum클래스;

public class BadExampleMain {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        System.out.println("카드 수수료: " + service.calculateFee(PaymentConstants.CARD, 10000));

        // 문제 상황 : 실수로 오타를 내거나 잘못된 값을 전달해도 컴파일 시점에 알 수 없음
        // 프러그램 실행 중에 서버가 터지거나 엉뚱한 결과가 나옴

        try{
            service.calculateFee("KAKAOPAY", 10000);
        }catch(Exception e){
            System.out.println("에러 발생: " + e.getMessage());
        }
    }
}
