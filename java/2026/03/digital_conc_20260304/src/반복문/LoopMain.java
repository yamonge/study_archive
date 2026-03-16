package 반복문;

import java.util.Scanner;

public class LoopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력 : ");
        int num = sc.nextInt();
        int sum = 0;
//        while(num > 0){
//            sum += num;
//            num--;
//            System.out.println(sum);
//        }

//        for(int i = 1; i <= num; i++){
//            sum += i;
//            System.out.println(sum);
//        }

        while(true){
            sum += num;
            num--;
            System.out.println(sum);
            if(num == 0) {
                break;
            }
        }
        System.out.println("반복문끝");
    }
}
