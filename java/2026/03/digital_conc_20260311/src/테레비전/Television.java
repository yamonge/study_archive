package 테레비전;

public class Television {
    boolean power;
    int volume;
    int channel;

    Television(){
        power = false;
        volume = 10;
        channel = 11;
    }

    Television(boolean onOff, int vol, int ch){
        power = onOff;
        volume = vol;
        channel = ch;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void printTV(){
        System.out.println("===== TV 정보 출력 =====");
        System.out.printf("전원: %s\n", (power ? "ON" : "Off"));
        System.out.println("채널: " + channel);
        System.out.println("볼륨: " + volume);

    }
}
