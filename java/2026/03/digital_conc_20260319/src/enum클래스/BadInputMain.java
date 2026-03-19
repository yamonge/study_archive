package enum클래스;

import java.util.Scanner;

public class BadInputMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentService service = new PaymentService();

        System.out.print("결제 수단 입력: ");
        String input = sc.nextLine();

        // 문제점2: 입력받은 '문자열'을 그대로 서비스에 넘김
        // 서비스 입장에서는 이 값이 안정한지 믿을수 없음

        service.process(input, 10000);
    }
}
