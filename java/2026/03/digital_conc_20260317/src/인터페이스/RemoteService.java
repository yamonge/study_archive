package 인터페이스;

public interface RemoteService {
    int MAX_VOLUME = 10; // 상수는 대문자로 작성하는 것이 관례입니다.
    int MIN_VOLUME = 0;
    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);

    default void setMute(boolean mute){
        if(mute){
            System.out.println("무음 처리 합니다.");
        }else{
            System.out.println("무음을 해제 합니다.");
        }
    }
}
