package 연산자실습;

import java.util.ArrayList;
import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하시오: ");
        int year = sc.nextInt();
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.printf("%d년은 윤년입니다.\n", year);
        }else{
            System.out.printf("%d년은 윤년이 아닙니다.\n", year);
        }

        sc.nextLine();

        System.out.print("3자리 정수를 입력해주세요: ");
        int num = sc.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int maxnum = 0;

        while (num > 0){
            ar.add(0, num % 10);
            num /= 10;
        }

        for (int i = 0; i < ar.size(); i++){
            if(ar.get(i) > maxnum){
                maxnum = ar.get(i);
            }
        }

        System.out.println(ar);
        System.out.printf("가장 큰수는 %d 입니다.", maxnum);

        //연산자 우선 순위
        int val1 = 5, val2 = 5, val3 = 5;
        int rst1 = val1 + val2 * val3;
        int rst2 = (val1 + val2) * val3;
        int rst3 = val1 + (++val2) * val3;
    }
}
