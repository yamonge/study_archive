package 인터페이스;

public interface RemoCon {
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;
    public void setVolume(int volume);
    public void turnOn();
    public void turnOff();
}
