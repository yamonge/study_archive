package 인터페이스실습;

import java.util.Scanner;

public abstract class Car {
    // 상수 FUELPRICE는 리터당 2000원으로 설정
    private final int FUELPRICE = 2000;
    // 인스턴스 필드 선언
    private int speed; // 최고 속도
    private double fuel; // 연비
    private int tankSize; // 연료 탱크 크기
    private int seatNum; // 좌석 수
    private String carName; // 자동차 이름
    private int totalmov; // 총 이동 횟수
    private int totalDis; // 총 이동 거리
    private double totalFuel; // 총 연료 소비량
    private boolean audio; // 오디오 기능 여부
    private boolean autoDrive; // 자율주행 기능 여부
    private boolean airCon; // 에어컨 기능 여부
    Scanner sc = new Scanner(System.in);

    // getter setter 및 생성자

    public Car(String carName) {
        this.carName = carName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getTankSize() {
        return tankSize;
    }

    public void setTankSize(int tankSize) {
        this.tankSize = tankSize;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public boolean isAutoDrive() {
        return autoDrive;
    }

    public void setAutoDrive(boolean autoDrive) {
        this.autoDrive = autoDrive;
    }

    public boolean isAirCon() {
        return airCon;
    }

    public void setAirCon(boolean airCon) {
        this.airCon = airCon;
    }

    public int mov(int passenger, int seatNum){
        this.totalmov = (int) Math.ceil((double) passenger / seatNum);
        return totalmov;
    }

    public int fuelCount(int distance){
        totalDis = distance * totalmov;
        totalFuel = (double) totalDis / fuel;
        int rst = (int) Math.ceil(totalFuel / tankSize);
        return rst;
    }

    public int totalMoney(){
        int money = (int) Math.ceil((double) totalFuel * FUELPRICE);
        return money;
    }

    public String totalTime(double weather){
        double time = (double) totalDis / speed * weather;
        double totalMinutes = time * 60;
        int hour = (int) totalMinutes / 60;
        int min = (int) totalMinutes % 60;
        return hour + "시간 " + min + "분";
    }

    public abstract void applySpecialFunction();

    public void airConPrint(){
        System.out.print("에어컨 ON/OFF [1]ON [2]OFF : ");
        int airConOption = sc.nextInt();
        if(airConOption != 1 && airConOption != 2){
            System.out.println("에어컨 옵션 선택이 잘못되었습니다.");
        }
        airCon = airConOption == 1;
        System.out.println(getCarName() + ": 에어컨 " + (airCon ? "ON" : "OFF"));
    }

    public void audioPrint(){
        System.out.print("오디오 ON/OFF [1]ON [2]OFF : ");
        int audioOption = sc.nextInt();
        if(audioOption != 1 && audioOption != 2){
            System.out.println("오디오 옵션 선택이 잘못되었습니다.");
        }
        audio = audioOption == 1;
            System.out.println(getCarName() + ": 오디오 " + (audio ? "ON" : "OFF"));
    }

    public void autoDrivePrint(){
        System.out.print("자율주행 ON/OFF [1]ON [2]OFF : ");
        int autoDriveOption = sc.nextInt();
        if(autoDriveOption != 1 && autoDriveOption != 2){
            System.out.println("자율주행 옵션 선택이 잘못되었습니다.");
        }
        autoDrive = autoDriveOption == 1;
        System.out.println(getCarName() + ": 자율주행 " + (autoDrive ? "ON" : "OFF"));
    }

    public void carRule(Car car){
        if(car instanceof SportsCar sportsCar){
            airConPrint();
            audioPrint();
            if(airCon){
                sportsCar.optionAirCon();
            }
            if(audio){
                sportsCar.optionAudio();
            }
        } else if(car instanceof Sedan sedan){
            airConPrint();
            audioPrint();
            autoDrivePrint();
            if(airCon){
                sedan.optionAirCon();
            }
            if(autoDrive){
                sedan.optionAutoDrive();
            }
            if (audio) {
                sedan.optionAudio();
            }
        } else if(car instanceof Bus bus){
            airConPrint();
            autoDrivePrint();
            if(airCon){
                bus.optionAirCon();
            }
            if(autoDrive){
                bus.optionAutoDrive();
            }
        }
    }

}
