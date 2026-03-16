package 표준입력;

import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    System.out.print("입력: ");
//    int age = sc.nextInt();
//    System.out.println(age);
//    sc.nextLine();
//    System.out.print("입력: ");
//    String name = sc.nextLine();
//    System.out.println(name);
//
//    byte a = sc.nextByte();
//    System.out.println(a);
//
//    sc.nextLine();
//
//    System.out.print("이름 : ");
//    String name2 = sc.nextLine();
//    System.out.println(name2);
//    System.out.print("문자char : ");
//    char str1 = sc.next().charAt(0);
//    System.out.println(str1);

        //이름은 next()
        //주소는 nextLine()
        //성별은 next().charAt(0) 'M' / "F"로 입력 받아서 출력은 "남성"과 "여성"으로 출력
        //직업은 [1]회사원, [2]학생, [3]주부, [4]무직 : 정수로 입력 받아서 문자열 출력
        //나이는 nextInt() 입력
        //엽력 완료시 결과를 출력

        System.out.print("이름 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("주소 : ");
        String addr = sc.nextLine();
        System.out.print("성별 : ");
        char one1 = sc.next().charAt(0);
        String gender;
        if(one1 == 'M'){
            gender = "남자";
        }
        else if(one1 == 'F'){
            gender = "여자";
        }
        else{
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            gender = "미정";
        }

        System.out.print("직업(숫자) : ");
        int nums = sc.nextInt();
        String jobs;
//        if(nums == 1){
//            jobs = "회사원";
//        }
//        else if(nums == 2){
//            jobs = "학생";
//        }
//        else if(nums == 3){
//            jobs = "주부";
//        }
//        else{
//            jobs = "무직";
//        }

        switch (nums){
            case 1:
                jobs = "회사원";
                break;
            case 2:
                jobs = "학생";
                break;
            case 3:
                jobs = "주부";
                break;
            default:
                jobs = "무직";
        }
        System.out.print("나이 : ");
        int age = sc.nextInt();
        System.out.println("===================");
        System.out.printf("이름 : %s \n", name);
        System.out.printf("주소 : %s \n", addr);
        System.out.printf("성별 : %s \n", gender);
        System.out.printf("직업 : %s \n", jobs);
        System.out.printf("나이 : %d \n", age);
        System.out.println("===================");


    }
}
