package 인터페이스;

public class InterfaceMain{
    public static void main(String[] args) {
        // 별도의 구현 클래스없이 일회용 객체 생성
        RemoCon rc = new RemoCon() {
            @Override
            public void setVolume(int volume) {

            }

            @Override
            public void turnOn() {
                System.out.println("오디오 전원을 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("오디오 전원을 끕니다.");
            }
        };
    }

}
