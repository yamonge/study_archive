package 스위치실습2번;

import java.util.Scanner;

public class SwitchEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("키를 입력해주세요: ");
        double height = sc.nextDouble();
        height = height / 100;
        System.out.print("몸무게를 입력해주세요: ");
        double weight = sc.nextDouble();

        double  bmi = weight / (height * height) ;

        String rst = "";
        if(bmi < 18.5) {
            rst = "저체중";
        }else if(18.5 <= bmi && bmi < 23){
            rst = "정상";
        }else if(23 <= bmi && bmi < 25){
            rst = "과체중";
        }else{
            rst = "비만";
        }

        System.out.printf("당신의 BMI는 %.2f 입니다.\n", bmi);
        System.out.printf("%s 체중 입니다.\n", rst);
    }
}
