package 연산자;

import java.util.Scanner;

// 연산자 : 프로그램에서 사용하는 값을 연산해야 하는 경우에 사용
    // 산술연산자 : 사직연산과 나머지 연산(+, -, *, /, %)
    // 대입연산자 : 변수에 값을 대입할 떄 사용 (=, +=, -=, *=, /=, %=)
    // 증감연산자 : ++, --, 단항연산자, 변수의 값을 1증가 혹은 1감소 시키는 연산자
    // 비교연산자 : ==, >, <, >=, <=, !=, 좌변과 우변의 값을 비교하여 결과를 참과 거짓으로 판별함
    // 논리연산자 : &&(and, 좌항과 우항이 모두 만족해야함), ||(or, 좌항과 우항 둘 중 하나만 만족하면 참), !(not, 현재상태를 부정)
    // 삼항연산자 : 참과 거짓만 있는 조건문을 만들 수 있음, 항이 3개인 연산자
    // 비트연산자 : 비트 단위의 연산을 수행
public class OperatorMain {
    public static void main(String[] args) {
        int x = 10, y = 4;
        System.out.println(x + y);
        System.out.println(x - y);
        System.out.println(x * y);
        System.out.println(x / y); // 나눈셈이 아니고 몫을 구하는 연산이 됨
        System.out.println((double)x / y); // 형변환
        System.out.println(x % y); // 나머지 연산자, 알고리즘에서는 산술연산자 중에서 나머지 연산자가 많이 사용됨

        //대입연산자
        int num1 = 10; // 정수 타입의 num1 변수에 10을 대입
        System.out.println(num1 += 2); // 복한대입연산자, num1 = num1 + 2
        System.out.println(num1 -= 2); // num1 = num1 - 2, 10
        System.out.println(num1 *= 2); // 20
        System.out.println(num1 /= 2); // 10
        System.out.println(num1 %= 2); // 0

        //증감연산자
        int num2 = 10;
        System.out.println(num2++); //선증가 후대입
        System.out.println(num2);

        //비교연산자
        int num3 = 10, num4 = 20;
        System.out.println(num3 == num4); // flase
        System.out.println(num3 != num4); // true
        System.out.println(num3 > num4); // false
        System.out.println(num3 < num4); // true
        System.out.println(num3 >= num4); // false
        System.out.println(num3 <= num4); // true

        //논리연산자
        int num5 = 10, num6 = 20;
        System.out.println(num5 > 0 && num5 > num6); // 산술연산자가 논리연산자 보다 우선 순위가 높음
        System.out.println(num5 > 0 || num5 > num6); // true
        System.out.println(!(num5 > 0 || num5 > num6)); // false

        //3항연산자 : 참과 거짓만 있는 조건문 대체
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력: ");
        int age = sc.nextInt();
        if(age >= 18){
            System.out.println("당신은 성인 입니다.");
        }else{
            System.out.println("당신은 미성년자 입니다.");
        }
        System.out.println("당신은 " + (age > 18 ? "성인" : "미성년자") + " 입니다");


    }
}
