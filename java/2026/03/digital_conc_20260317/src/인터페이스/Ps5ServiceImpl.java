package 인터페이스;

public class Ps5ServiceImpl implements RemoteService {
    int volume;

    @Override
    public void turnOn() {
        System.out.println("PS5를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("PS5를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteService.MAX_VOLUME){
            this.volume = RemoteService.MAX_VOLUME;
        } else if(volume < RemoteService.MIN_VOLUME){
            this.volume = RemoteService.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("PS5 볼륨이 " + this.volume + "로 설정되었습니다.");
    }

    public void playGame(String game) {
        System.out.println(game + " 게임을 시작합니다.");
    }
}
