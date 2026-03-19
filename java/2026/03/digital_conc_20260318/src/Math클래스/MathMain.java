package Math클래스;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MathMain {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.printf("%d ", (int)(Math.random() * 100 + 1));
        }

        System.out.println();
        // 중복 되는 로또 번호 생성 하기
        // 1 ~ 45 사이의 임의 값 6개
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(true){
            int num = (int)(Math.random() * 45 + 1);
            if(!list.contains(num)){
                list.add(num);
                count++;
            }
            if(count == 6){
                break;
            }
        }
        Collections.sort(list);
        System.out.println(list);

        System.out.println(Math.abs(-10));
        System.out.println(Math.floor(10.5));
        System.out.println(Math.round(10.5));
        System.out.println(Math.min(100, 200));
        System.out.println(Math.max(200, 100));

        // 실습문제
        // 1. 일주일 기온 데이터 출력 (1일 ~ 7일)
        // 2. 최저기온, 최고기온, 일교차 출력 하기

        int[] temps = {-5, 3, -12, 7, -1, 15, -8};
        int max = temps[0];
        int min = temps[0];
        for(int i=0; i < temps.length; i++){
            System.out.printf("%d일: %d도 | ", i+1, temps[i]);
            if(temps[i] > max){
                max = temps[i];
            }
            if(temps[i] < min){
                min = temps[i];
            }
        }
        System.out.println();
        System.out.println("최고 기온: " + max);
        System.out.println("최저 기온: " + min);
        System.out.println("일교차 : " + Math.abs(max - min));



    }
}
