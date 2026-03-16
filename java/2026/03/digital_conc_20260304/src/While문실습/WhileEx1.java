package While문실습;

    // 이름은 문자열로 입력
    // 나이는 정수로 입력 받는데 0 ~ 199 까지는 정상 입력, 나머지 수는 "나이 입력이 잘 못 되었습니다." 재 입력 받기
    // 성별은 문자로 입력 'M','m','F','f' 만 정상 입력으로 간주하고 다른 문자이면 "성별을 잘 못 입력하셧습니다." 재 입력 받기
    // 직업은 정수로 입력 [1]회사원, [2]학생, [3]주부, [4]무직 1 ~ 4 사이의 값이 아니면 "직업을 잘 못 입력 하셨습니다." 재 입력 받기
    // - 출력은 "회사원","학생","주부","무직"
    // 모든 입력이 정상적으로 입력되면 출력 하기

import java.util.Scanner;

public class WhileEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하시오: ");
        String name = sc.nextLine();
        int age = 0;
        String gender = "";
        String job = "";
        while(true){
            System.out.print("나이를 입력하시오: ");
            int val1 = sc.nextInt();
            if(val1 > 0 && val1 < 200){
                age = val1;
                break;
            }else{
                System.out.println("나이 입력이 잘 못 되었습니다.");
                continue;
            }
        }

        sc.nextLine();

        while(true){
            System.out.print("성별을 입력하시오: ");
            char val2 = sc.nextLine().charAt(0);
            boolean gender_vaild = false;
            switch(val2){
                case 'M':
                case 'm':
                    gender = "남성";
                    gender_vaild = true;
                    break;
                case 'F':
                case 'f':
                    gender = "여성";
                    gender_vaild = true;
                    break;
                default:
                    System.out.println("성별 입력이 잘 못 입력 되었습니다.");
                    continue;
            }
            if(gender_vaild){
                break;
            }
        }
        while(true){
            System.out.print("직업을 입력하시오(정수) : ");
            int val3 = sc.nextInt();
            boolean job_vaild = true;
            switch(val3){
                case 1:
                    job = "회사원";
                    break;
                case 2:
                    job = "학생";
                    break;
                case 3:
                    job = "주부";
                    break;
                case 4:
                    job = "무직";
                    break;
                default:
                    System.out.println("직업을 잘 못 입력 하셧습니다.");
                    job_vaild = false;
                    continue;
            }

            if(job_vaild){
                break;
            }
        }

        System.out.printf("%s님의 나이는 %d 이며 성별은 %s 이고 직업은 %s 입니다.", name, age, gender, job);
    }
}
