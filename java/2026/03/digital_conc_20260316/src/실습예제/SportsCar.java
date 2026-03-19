package 실습예제;

public class SportsCar extends Car {
    public SportsCar(String name){
        super(name);
        this.setSpeed(250);
        this.setFuel(8);
        this.setTankSize(30);
        this.setSeatNum(2);
    }

    @Override
    public void applySpecialFunction() {
        System.out.println(getCarName() + "의 터보 모드: 속도가 20% 증가합니다.");
        this.setSpeed((int) Math.ceil((double) this.getSpeed() * 1.2));
    }
}
