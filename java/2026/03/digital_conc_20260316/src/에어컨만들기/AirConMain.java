package 에어컨만들기;

import java.util.Scanner;

public class AirConMain {
    public static void main(String[] args) {
        AirCon myAircon = new AirCon();
        Scanner sc = new Scanner(System.in);

        System.out.print("에어컨을 켜시겠습니까? (yes/no): ");
        String onOff = sc.nextLine().trim().toLowerCase();

        if(onOff.equalsIgnoreCase("yes")){
            myAircon.setPower(true);
            myAircon.setAirCon(sc);
            myAircon.operate();
        }else{
            System.out.println("에어컨이 켜지지 않았습니다. 프로그램을 종료합니다.");
        }
    }
}
