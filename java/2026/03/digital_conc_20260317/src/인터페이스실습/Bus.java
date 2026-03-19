package 인터페이스실습;

public class Bus extends Car implements AirconService, AutoDriveServiec {
    public Bus(String name){
        super(name);
        this.setSpeed(250);
        this.setFuel(8);
        this.setTankSize(30);
        this.setSeatNum(2);
    }

    @Override
    public void applySpecialFunction() {
        System.out.println(getCarName() + "의 부가 기능: 보조 연료탱크 30L가 추가됩니다.");
        this.setTankSize(getTankSize() + 30);
    }

    @Override
    public void optionAirCon(){
        this.setFuel(getFuel() * 0.95); // 에어컨이 켜지면 연비 -5%
    }

    @Override
    public void optionAutoDrive(){
        this.setSpeed((int)(getSpeed() * 0.9)); // 자율주행이 켜지면 속도 -10%
    }
}
