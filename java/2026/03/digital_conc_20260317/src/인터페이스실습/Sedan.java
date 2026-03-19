package 인터페이스실습;

public class Sedan extends Car implements AirconService, AudioService, AutoDriveServiec{
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

    @Override
    public void optionAutoDrive(){
        this.setSpeed((int)(getSpeed() * 0.9)); // 자율주행이 켜지면 속도 -10%
    }

    @Override
    public void optionAudio(){

    }

    @Override
    public void optionAirCon(){
        this.setFuel(getFuel() * 0.95); // 에어컨이 켜지면 연비 -5%
    }
}
