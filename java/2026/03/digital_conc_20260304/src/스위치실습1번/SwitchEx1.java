package 스위치실습1번;

    // 좌변 값, 연산자, 우변값을 입력 받아 산술 연산을 수행하는 스위치문 만들기

import java.util.Scanner;

public class SwitchEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("좌변값: ");
        int leftNum = sc.nextInt();
        sc.nextLine();
        System.out.print("연산자: ");
        String operator = sc.nextLine();
        System.out.print("우변값: ");
        int rightNum = sc.nextInt();
        int rst = 0;
        switch(operator){
            case "+":
                rst = leftNum + rightNum;
                break;
            case "-":
                rst = leftNum - rightNum;
                break;
            case "*":
                rst = leftNum * rightNum;
                break;
            case "/":
                rst = leftNum / rightNum;
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

        System.out.println("결과값: " + rst);


    }
}
