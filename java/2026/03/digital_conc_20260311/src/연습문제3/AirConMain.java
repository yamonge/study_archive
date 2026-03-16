package 연습문제3;

import java.util.Scanner;

public class AirConMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AirCon ac = new AirCon();
        Excep ex = new Excep();
        CreateMenu cm = new CreateMenu();

        while(true){
            cm.create("에어컨", "전원", "현재온도", "모드변경", "바람세기", "정보");
            String number = sc.nextLine();
            int num = ex.num(number, 5);
            switch(num){
                case 1:
                    cm.create("전원", "켜기", "끄기");
                    String menu = sc.nextLine();
                    int menuNum = ex.num(menu, 2);

            }
        }
    }
}
