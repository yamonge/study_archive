package 변수와자료형;

import java.util.Scanner;

public class DataTypeMain {
    public static void main(String[] args) {
        int age;
        int age1234;
        int $$$$$age;
        int _____age12345;

//        int 12age;
        int memberInfo;
        int member_info;
        age = 20;
        User userInfo;
        String name = "곰돌이사육사";
        String phone = "010-1234-5678";
        boolean isAdult = true;
        char gender = 'M';
        int genderNumber = gender;

        System.out.println("나이 : " + age);
        System.out.println("이름 : " + name);
        System.out.println("핸드폰 : " + phone);
        System.out.println("성인 여부 : " + isAdult);
        System.out.println("성별 : " + gender);
        System.out.println("성별코드 : " + genderNumber + " 성별 : " + gender);

        String addr = "경기도 수원시 권선구 권선동";
        byte num1 = 127;
        float height = 0.1f; // f반드시 붙혀야함
        double weight = 1.7;
        double num2 = 0.1;
        System.out.println(addr);
        System.out.println(num1);
        System.out.println(height);
        System.out.println(weight);
        System.out.println(num2);
        //double의 오차 범위
        System.out.println(num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2 + num2);
        System.out.println(height + height + height + height + height + height + height + height + height + height);

        final double taxRate = 0.10;
        Scanner sc = new Scanner(System.in);
        System.out.print("수입을 입력 하세요 : ");
        int income = sc.nextInt();
        System.out.println("당신이 내야할 세금은 " + income * taxRate + "입니다.");

        int val1 = 10, val2 = 4;
        double rst1 = val1/(double)val2;
        System.out.println(rst1);

        int kor = 99, eng = 66, mat = 77;
        double avg = (kor + eng + mat) / 3.0;
        System.out.printf("%.2f\n", avg);

        String val3 = "0100.234";
        System.out.println(300 + Double.parseDouble(val3));

    }
}
