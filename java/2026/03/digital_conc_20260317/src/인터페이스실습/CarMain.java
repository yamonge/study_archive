package 인터페이스실습;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = 0;
        int passengers = 0;
        while (true) {
            System.out.print("이동 지역 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
            int areaChoice = sc.nextInt();
            switch (areaChoice) {
                case 1: distance = 400; break;
                case 2: distance = 150; break;
                case 3: distance = 200; break;
                case 4: distance = 300; break;
                default:  System.out.println("지역 선택을 잘못 하셨습니다");
                    continue;
            }
            System.out.print("이동할 승객 수 (1 ~ 100) : ");
            passengers = sc.nextInt();
            if (passengers < 1 || passengers > 100) {
                System.out.println("승객 수는 1 ~ 100 사이여야 합니다. 다시 입력하세요.");
                continue;
            }
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
            int carChoice = sc.nextInt();
            Car myCar = null;
            if (carChoice == 1) {
                myCar = new SportsCar("포르쉐 911");
            } else if (carChoice == 2) {
                myCar = new Sedan("G80");
            } else if (carChoice == 3) {
                myCar = new Bus("마을버스");
            } else {
                System.out.println("차량 선택이 잘못되었습니다.");
                continue;
            }
            System.out.print("부가기능 선택 [1]ON [2]OFF : ");
            int option = sc.nextInt();
            boolean isOptionOn = false;
            if (option == 1) {
                isOptionOn = true;
            } else if (option == 2) {
                isOptionOn = false;
            } else {
                System.out.println("옵션 선택이 잘못되었습니다.");
                continue;
            }
            System.out.print("날씨 선택 [1]맑음 [2]비 [3]눈 : ");
            int weatherChoice = sc.nextInt();
            double weatherWeight = 0;
            if (weatherChoice == 1) {
                weatherWeight = 1.0;
            } else if (weatherChoice == 2) {
                weatherWeight = 1.2;
            } else if (weatherChoice == 3) {
                weatherWeight = 1.4;
            } else {
                System.out.println("날씨 선택이 잘못되었습니다.");
                continue;
            }
            if (isOptionOn) {
                myCar.applySpecialFunction();
                myCar.carRule(myCar);
            }
            System.out.println("\n=====" + myCar.getCarName() + "=====");
            myCar.mov(passengers, myCar.getSeatNum());
            int refuel = myCar.fuelCount(distance);
            int cost = myCar.totalMoney();
            String time = myCar.totalTime(weatherWeight);
            System.out.printf("총 비용 : %,d원\n", cost);
            System.out.println("총 주유 횟수 : " + refuel + "회");
            System.out.println("총 이동 시간 : " + time);
            if(myCar instanceof SportsCar){
                System.out.println("에어컨 : " + (myCar.isAirCon() ? "ON" : "OFF"));
                System.out.println("오디오 : " + (myCar.isAudio() ? "ON" : "OFF"));
            }else if(myCar instanceof Sedan){
                System.out.println("에어컨 : " + (myCar.isAirCon() ? "ON" : "OFF"));
                System.out.println("오디오 : " + (myCar.isAudio() ? "ON" : "OFF"));
                System.out.println("자율주행 : " + (myCar.isAutoDrive() ? "ON" : "OFF"));
            }else{
                System.out.println("에어컨 : " + (myCar.isAirCon() ? "ON" : "OFF"));
                System.out.println("자율주행 : " + (myCar.isAutoDrive() ? "ON" : "OFF"));
            }
            break;
        }
    }
}

