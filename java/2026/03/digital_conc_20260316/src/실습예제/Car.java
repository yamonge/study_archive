package 실습예제;

public abstract class Car {
    // 상수 FUELPRICE는 리터당 2000원으로 설정
    private final int FUELPRICE = 2000;
    // 인스턴스 필드 선언
    private int speed;
    private double fuel;
    private int tankSize;
    private int seatNum;
    private String carName;
    private int totalmov;
    private int totalDis;
    private double totalFuel;

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
}
