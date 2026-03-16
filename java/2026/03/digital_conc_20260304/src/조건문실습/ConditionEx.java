package 조건문실습;

import java.util.Scanner;

    // 시간과 분을 입력받아 45분 일찍 시간이 설정되도록 구현
    // 23:45 => 23:00
    // 00:30 => 23:45
    // 00:45 => 00:00
    // 13:40 => 12:55

public class ConditionEx {
    public static void main(String[] args) {
        // 스캐너 객체 생성
        Scanner sc = new Scanner(System.in);

        // 시간 / 분 입력 받기
        System.out.print("시간을 입력해주세요: ");
        int hour = sc.nextInt();
        System.out.print("분을 입력해주세요: ");
        int min = sc.nextInt();

        // 계산 편의를 위해서 전부 분으로 환산
        int total = (hour * 60) + min;
        // 환산된 분이 45분 미만이면 하루치 시간을 더해줌
        if(total < 45){
            total += 1440;
        }
        // 환산된 시간에서 45를 빼줌
        total -= 45;
        // 다시 시간과 분으로 환산 후 결과 출력
        hour = total / 60;
        min = total % 60;

        System.out.printf("설정된 시간: %d시 %d분", hour, min);



    }
}
