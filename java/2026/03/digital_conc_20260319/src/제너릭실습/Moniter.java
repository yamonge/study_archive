package 제너릭실습;

public class Moniter extends Device{
    @Override
    public void turnOn() {
        System.out.println("모니터의 전원을 킵니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("모니터의 전원을 끕니다.");
    }
}
