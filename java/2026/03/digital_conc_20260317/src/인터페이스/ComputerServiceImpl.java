package 인터페이스;

public class ComputerServiceImpl implements ComputerService{
    private boolean isOn;
    private int volume;
    private int brightness;
    private int contrast;

    public void turnOn() {
        System.out.println("컴퓨터가 켜졌습니다.");
    }

    public void turnOff() {
        System.out.println("컴퓨터가 꺼졌습니다.");
    }

    public void setVolume(int volume) {
        System.out.println("컴퓨터 볼륨이 " + volume + "로 설정되었습니다.");
    }

    public void setBrightness(int brightness) {
        System.out.println("컴퓨터 밝기가 " + brightness + "로 설정되었습니다.");
    }

    public void setContrast(int contrast) {
        System.out.println("컴퓨터 명암이 " + contrast + "로 설정되었습니다.");
    }
}
