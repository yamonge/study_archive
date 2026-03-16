package 조건문;

import java.util.Scanner;

public class ConditionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("정수 입력: ");
//        int num = sc.nextInt();
//
//        if(num > 100){
//            System.out.print(num + "은 100 보다 커요");
//        }else if(num < 100){
//            System.out.println(num + "은 100 보다 작아요.");
//        }else {
//            System.out.println(num + "은 100과 같아요");
//        }
//
//        sc.nextLine();
        // 이름, 국어, 영어, 수학 성적 입력 받기
        // 각각의 성적이 0~100 사이가 아니면 "성적 입력 오류" 출력 후 종료
        // 성적이 제대로 입력 되면 총점과 평균 구하기
        // 평균이 90점 이상이면 이름, 총점, 평균, 등급 : A
        // 평균이 80점 이상이면 이름, 총점, 평균, 등급 : B
        // 평균이 70점 이상이면 이름, 총점, 평균, 등급 : C
        // 평균이 60점 이상이면 이름, 총점, 평균, 등급 : D
        // 평균이 60점 미만이면 이름, 총점, 평균, 등급 : F

        System.out.print("이름을 입력하시오 : ");
        String name = sc.nextLine();
        System.out.print("국어 성적을 입력하시오: ");
        int kor = sc.nextInt();
        System.out.print("영어 성적을 입력하시오: ");
        int eng = sc.nextInt();
        System.out.print("수학 성적을 입력하시오: ");
        int mat = sc.nextInt();

        int rst = 0;
        double avg = 0;

        if(kor <= 100 && eng <= 100 && mat <= 100){
            rst = kor + eng + mat;
            avg = (double)rst / 3;
            if(avg >= 90){
                System.out.printf("%s님의 총점: %d 평균: %.1f 등급: A", name, rst, avg);
            }else if(avg >= 80){
                System.out.printf("%s님의 총점: %d 평균: %.1f 등급: B", name, rst, avg);
            }else if(avg >= 70){
                System.out.printf("%s님의 총점: %d 평균: %.1f 등급: C", name, rst, avg);
            }else if(avg >= 60){
                System.out.printf("%s님의 총점: %d 평균: %.1f 등급: D", name, rst, avg);
            }else{
                System.out.printf("%s님의 총점: %d 평균: %.1f 등급: F", name, rst, avg);
            }
        }else {
            System.out.println("성적 입력 오류");
        }
    }
}
