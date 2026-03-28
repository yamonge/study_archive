package 사용자예외클래스;

import java.util.Scanner;

public class CustomEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수값를 입력하세요: ");
        int num = sc.nextInt();
        sc.nextLine();

        CheckEven checkEven = new CheckEven();
    }
}

class CheckEven extends Exception {
    private int num;

    public CheckEven() {
    }
}