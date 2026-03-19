package 제너릭실습;

public class Printer extends Device{
    @Override
    public void turnOn() {
        System.out.println("프린터의 전원을 킵니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("프린터의 전원을 끕니다.");
    }
}
