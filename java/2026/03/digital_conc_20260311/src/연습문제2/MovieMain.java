package 연습문제2;

    // 좌석은 10개
    // 빈 좌석은, [], 예매됨 [V]
    // 영화표 가격은 생성자에서 매개변수 전달 받음
    // 생성자
    // 좌석 상태 출력 매서드
    // 에매 기능 수행하는 메서드
    // 최소 기능 수행하는 메서드
    // 총 판매 금액 반환

    // Main에서 해야할것
    // MovieTicket 클래스를 사용해서 객체 생성
    // 입력을 받기위한 스케너 객체 생성
    // 메뉴 기능 구현을 위해 무한 반복문
    // 메뉴 이름을 출력
    // 메뉴 선택하기
    // 선택된 메뉴 실행


import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        MovieTicket mv = new MovieTicket(8000);
        Scanner sc = new Scanner(System.in);

        while(true){
            int number = 0;
            System.out.println("=========================");
            System.out.println("======== 영화 얘매 ========");
            System.out.println("=========================");
            System.out.println("1. 좌석보기");
            System.out.println("2. 예매하기");
            System.out.println("3. 예매취소하기");
            System.out.println("4. 총 판매금액 보기");
            System.out.println("0. 나가기");
            System.out.println("=========================");
            try{
                System.out.print("숫자를 입력해주세요: ");
                int num = sc.nextInt();
                if(num < 0){
                    System.out.println("음수는 안됩니다. 다시 입력해주세요.");
                    continue;
                }else if(num > 4){
                    System.out.println("없는 메뉴 입니다 다시 입력해주세요.");
                    continue;
                }else{
                    if(num == 0){
                        break;
                    }else{
                        number = num;
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("숫자만 입력해주세요.");
                sc.next();
                continue;
            }

            switch (number){
                case 1:
                    mv.printSeat();
                    break;
                case 2:
                    System.out.println("=========================");
                    System.out.println("======== 예매하기 ========");
                    System.out.println("=========================");
                    while (true) {
                        try {
                            System.out.print("숫자를 입력해주세요: ");
                            int num2 = sc.nextInt();
                            if (num2 < 0) {
                                System.out.println("음수 또는 0은 안됩니다 다시 입력해주세요.");
                                continue;
                            } else if(num2 == 0){
                                break;
                            } else if (num2 > 10) {
                                System.out.println("없는 좌석 입니다 다시 입력해주세요.");
                                continue;
                            } else {
                                if (mv.selectSeat(num2)) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("숫자만 입력해주세요.");
                            sc.next();
                            continue;
                        }
                    }
                    break;
                case 3:
                    System.out.println("=========================");
                    System.out.println("======== 예매 취소하기 ========");
                    System.out.println("=========================");
                    while (true) {
                        try {
                            System.out.print("숫자를 입력해주세요(0나가기): ");
                            int num3 = sc.nextInt();
                            if (num3 < 0) {
                                System.out.println("음수는 안됩니다 다시 입력해주세요.");
                                continue;
                            }else if(num3 == 0){
                                break;
                            }else if (num3 > 10) {
                                System.out.println("없는 좌석 입니다 다시 입력해주세요.");
                                continue;
                            } else {
                                if (mv.cancelSeat(num3)) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("숫자만 입력해주세요.");
                            sc.next();
                            continue;
                        }
                    }
                    break;
                default:
                    System.out.printf("총금액은 %d원 입니다.\n", mv.getTotalAmount());
            }

        }
    }
}
