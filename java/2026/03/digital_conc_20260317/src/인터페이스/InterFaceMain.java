package 인터페이스;

import java.util.Scanner;

public class InterFaceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("리모컨으로 동작할 제품 선택 [1]TV [2]PS5: ");
        int choice = sc.nextInt();
        RemoteService rc = null;
        if(choice == 1){
            rc = new TelevisionServiceImpl();
            TelevisionServiceImpl tv = (TelevisionServiceImpl) rc; // 다운캐스팅
            tv.turnOn();
            tv.setVolume(30);
            tv.setChannel(5);
            tv.turnOff();
        } else if(choice == 2){
            rc = new Ps5ServiceImpl();
            Ps5ServiceImpl ps5 = (Ps5ServiceImpl) rc; // 다운캐스팅
            ps5.turnOn();
            ps5.setVolume(20);
            ps5.playGame("Spider");
        }
    }
}
