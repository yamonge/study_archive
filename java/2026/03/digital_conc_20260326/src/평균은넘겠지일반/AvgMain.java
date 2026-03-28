package 평균은넘겠지일반;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AvgMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calc calc = null;
        int testCnt = 0;
        HashMap<Integer, List<Integer>> scoresList = new HashMap<>();
        while(true){
            try{
                System.out.print("테스트 케이스 수 입력: ");
                int t = sc.nextInt();
                sc.nextLine();
                testCnt = t;
                for(int i = 0; i < t; i++) {
                    System.out.print("학생 수와 점수 입력: ");
                    String input = sc.nextLine();
                    String[] parts = input.split(" ");
                    int n = Integer.parseInt(parts[0]);
                    List<Integer> scores = new ArrayList<>();
                    for (int j = 1; j <= n; j++) {
                        scores.add(Integer.parseInt(parts[j]));
                    }
                    scoresList.put(i, scores);
                }
                calc = new Calc(testCnt, scoresList);
                List<Double> result = calc.avg();
                for(Double percentage : result){
                    System.out.printf("%.3f%%\n", percentage);
                }
            }catch(RangeCheck e){
                System.out.println(e.getMessage());
            }
        }
    }
}
