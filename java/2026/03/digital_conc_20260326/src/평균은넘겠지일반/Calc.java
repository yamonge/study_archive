package 평균은넘겠지일반;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calc {
    private int testCaseCount;
    private HashMap<Integer, List<Integer>> testCases;

    public Calc(int testCaseCount, HashMap<Integer, List<Integer>> testCases) throws RangeCheck {
        if(testCaseCount <= 0 || testCases.size() != testCaseCount){
            throw new RangeCheck("테스트 케이스 수는 1보다 커야하며, 입력된 테스트 케이스 수와 일치해야 합니다. 입력값: " + testCaseCount);
        }
        for(Integer key : testCases.keySet()){
            List<Integer> scores = testCases.get(key);
            if(scores.size() == 0 || scores.size() > 1000){
                throw new RangeCheck("학생 수는 1에서 1000 사이여야 합니다. 입력값: " + scores.size());
            }
            for(Integer score : scores){
                if(score < 0 || score > 100){
                    throw new RangeCheck("점수는 0에서 100 사이여야 합니다. 입력값: " + score);
                }
            }
        }
        this.testCaseCount = testCaseCount;
        this.testCases = testCases;
    }

    public List<Double> avg(){
        List<Double> percentages = new ArrayList<>();
        for(int key : testCases.keySet()){
            List<Integer> scores = testCases.get(key);
            int sum = 0;
            for(Integer score : scores){
                sum += score;
            }
            double average = (double) sum / scores.size();
            int aboveAverageCount = 0;
            for(Integer score : scores){
                if(score > average){
                    aboveAverageCount++;
                }
            }
            double percentage = (double) aboveAverageCount / scores.size() * 100;
            percentages.add(percentage);
        }
        return percentages;
    }
}
