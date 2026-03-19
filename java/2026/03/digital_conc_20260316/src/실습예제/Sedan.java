package 실습예제;

public class Sedan extends Car{
    public Sedan(String name) {
        super(name);
        this.setSpeed(200);
        this.setFuel(12);
        this.setTankSize(45);
        this.setSeatNum(4);
    }

    @Override
    public void applySpecialFunction() {
        System.out.println(getCarName() + "의 부가 기능: 좌석이 1석 추가됩니다.");
        this.setSeatNum(getSeatNum() + 1);
    }
}
