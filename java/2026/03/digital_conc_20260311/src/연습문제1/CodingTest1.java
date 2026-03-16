package 연습문제1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CodingTest1 {
    public static void main(String[] args) {
        Decimal dc = new Decimal();
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.print("정수를 입력해주세요: ");
                int number = sc.nextInt();
                if(number < 0){
                    System.out.println("음수는 안됩니다. 다시 입력해주세요.");
                    continue;
                }else {
                    dc.num(number);
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("에러: 숫자가 아닙니다. 문자나 특수문자는 안됩니다!");
                sc.next();
                continue;
            }
        }

    }
}
