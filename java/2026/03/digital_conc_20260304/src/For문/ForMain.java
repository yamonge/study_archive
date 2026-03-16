package For문;

import java.util.Scanner;

public class ForMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
//
//        for(int i = 0; i < num; i++){
//            System.out.print("*");
//        }
//        System.out.println();

        // 정수값을 입력 받음
        // 입력 받은 정수값 범위의 5의 배수를 1줄에 10개씩 출력 하기
//        int count = 0;
//        for(int i = 1; i <= num; i++){
//            if(i % 5 == 0){
//                System.out.printf("%d ", i);
//                count++;
//                if(count % 10 == 0){
//                    System.out.println();
//                }
//            }
//        }
        // 정수 num을 입력 받아 num * num 출력하기
        // 싱글 for문 사용하기
        // 입력 : 4
        // 1 2 3 4
        // 5 6 7 8
        // 9 10 11 12
        // 13 14 15 16
        // 줄맞춤 필요

        int rst = num * num;
        System.out.println(rst);

        for(int i =1; i <= rst; i++){
            System.out.printf("%3d", i);
            if( i % 4 == 0){
                System.out.println();
            }
        }

        // 문자열을 입력 받아 역순으로 출력하기
        // "ABCDEFG" -> "abcdefg"
        sc.nextLine();
        System.out.print("문자열을 입력해주세요.: ");
        String str = sc.nextLine();
        String rst2 = "";
        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            if(Character.isUpperCase(a)){
                rst2 += Character.toLowerCase(a);
            }else{
                rst2 += Character.toUpperCase(a);
            }
        }
        System.out.println(rst2);

    }
}
