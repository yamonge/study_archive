package 스위치문;

import java.util.Scanner;

public class SwitchMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("좋아 하는 계절을 입력 하세요 : ");
        String sesson = sc.nextLine().toUpperCase();
        switch(sesson){
            case "SPRING":
                System.out.println("꽃이 피는 봄이 좋아요");
                break;
            case "SUMMER":
                System.out.println("놀고 싶은 여름이 좋아요");
                break;
            case "FALL":
            case "AUTUMN":
                System.out.println("시원하고 선선한 가을이 좋아여");
                break;
            case "WINTER":
                System.out.println("낭만있는 겨울이 좋아요");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }

    }
}
