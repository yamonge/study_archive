package 상속TV;

import java.util.Scanner;

public class TvMain extends ProtoTypeTv{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Exp exp = new Exp();
        CreateMenu cm = new CreateMenu();
        ProductTv pt1 = new ProductTv();
        ProductTv pt2 = new ProductTv(false, 7, 2, "smartTv");
        while(true){
            cm.creatMenu("TV" + "전원: " + (pt1.isPower() ? "켜짐" : "꺼짐"), "종료","전원", "채널", "볼륨", "스마트모드");
            String number = sc.nextLine();
            int menuNum = exp.num(number, 4);
            if (menuNum == -1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch (menuNum){
                case 1:
                    cm.creatMenu("전원", "나기기", "켜기", "끄기");
                    String menu = sc.nextLine();
                    int menuNum2 = exp.num(menu, 2);
                    if(menuNum2 == 0){
                        break;
                    }else if(menuNum2 == 1){
                        pt1.setPower(true);
                    }else{
                        pt1.setPower(false);
                    }
                    break;
                case 2:
                    if(!pt1.isPower()){
                        System.out.println("전원을 켜주세요!");
                        break;
                    }
                    cm.creatMenu("채널", "나가기");
                    String menu2 = sc.nextLine();
                    int menuNum3 = exp.num(menu2, 1999);
                    if(menuNum3 == 0){
                        break;
                    }
                    if(menuNum3 != -1){
                        pt1.setChannel(menuNum3);
                        System.out.println("현재 채널: " + pt1.getChannel());
                    }
                    break;
                case 3:
                    if(!pt1.isPower()){
                        System.out.println("전원을 켜주세요!");
                        break;
                    }
                    cm.creatMenu("볼륨", "나가기");
                    String menu3 = sc.nextLine();
                    int menuNum4 = exp.num(menu3, 100);
                    if(menuNum4 == 0){
                        break;
                    }
                    if(menuNum4 != -1){
                        pt1.setVolume(menuNum4);
                        System.out.println("현재 음량: " + pt1.getVolume());
                    }
                    break;
                default:
                    System.out.println("종료합니다.");
                    break;

            }
            if(menuNum == 0){
                break;
            }
        }
    }
}
