package 에어컨만들기;

import java.util.Calendar;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class AirCon {
    private boolean power;
    private int tempSet;
    private int tempNow;
    private boolean cooler;
    private boolean heater;
    private int wind;
    private final int[] step = {0, 1, 2, 3};


    public void setPower(boolean power) {
        this.power = power;
    }


    public AirCon(){
        final int[] monthTempArr = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        tempNow = monthTempArr[month];

        power = false;
        tempSet = 20;
        tempNow = 20;
        cooler = false;
        heater = false;
        wind = 1;
    }

    public void printAirCon(){
        System.out.println("전원: " + (power ? "ON" : "OFF"));
        System.out.println("설정 온도: " + tempSet);
        System.out.println("현재 온도: " + tempNow);
        System.out.println("냉방: " + (cooler ? "ON" : "OFF"));
        System.out.println("난방: " + (heater ? "ON" : "OFF"));
        System.out.println("풍량: " + step[wind]);
    }

    public void operate(){
        int elapsedTime = 0; // 경과 시간을 초 단위로 계산
        boolean changeTemp = false; // 온도가 변경되었는지 여부

        System.out.println("\n===== 에어컨 작동을 시작합니다 =====");
        printAirCon();

        try{
            while(true){
                sleep(1000); // 1초마다 상태 업데이트
                elapsedTime++;
                int getTimeThreshold = getTimeFunc();

                if(elapsedTime >= getTimeThreshold){ // 온도를 바꿔야 할 상황
                    changeTemp = true;
                }

                if(changeTemp){
                    if(cooler) setTempNow(-1);
                    if(heater) setTempNow(+1);
                    printAirCon();
                    elapsedTime = 0;
                    changeTemp = false;
                }
                if(tempNow == tempSet){
                    System.out.println("목적 온도에 도달했습니다. 에어컨을 종료합니다.");
                    power = false;
                    break;
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void setAirCon(Scanner sc) {
        System.out.println("현재온도는 " + tempNow + "도 입니다.");
        System.out.print("온도 설정: ");
        tempSet = sc.nextInt();
        System.out.print("바람 설정: ");
        wind = sc.nextInt();

        if (tempNow > tempSet) {
            System.out.println("냉방이 시작됩니다.");
            cooler = true;
            heater = false;
        } else if (tempNow < tempSet) {
            System.out.println("난방이 시작됩니다.");
            cooler = false;
            heater = true;
        } else {
            System.out.println("현재 온도가 설정 온도와 같습니다. 에어컨이 작동하지 않습니다.");
            cooler = false;
            heater = false;
        }
    }

    // 현재 온도 변경 메서드
    private void setTempNow(int temp){
        tempNow += temp;
    }

    private int getTimeFunc(){
        return switch (wind) {
            case 2 -> 30;
            case 3 -> 20;
            default -> 60;
        };
    }
}
