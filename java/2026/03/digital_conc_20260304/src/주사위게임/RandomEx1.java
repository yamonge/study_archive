package 주사위게임;

import java.math.*;
import java.util.ArrayList;

public class RandomEx1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        while (true) {
            int rand = (int)(Math.random() * 45 + 1);
            if (!arr.contains(rand)) {
                arr.add(rand);
                count++;
            }
            if(count == 6){
                break;
            }
        }
        System.out.println(arr);

        // 2개의 주사위를 굴려서 두 개의 주사위 수가 같은 값이 나오면 무인도 탈출 하기
        // 탈출 시 두개의 주사위 값을 표시하고, 몇번만에 탈출 했는지 횟수 표시

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        int count2 = 0;

        while(true){
            dice1.roll();
            dice2.roll();
            count2++;
            System.out.printf("주사위1: %s, 주사위2: %s\n", dice1.getNum(), dice2.getNum());
            if(dice1.getNum() == dice2.getNum()){
                break;
            }
        }

        System.out.printf("탈출! 주사위 굴린 횟수: %d\n", count2);


    }
}
