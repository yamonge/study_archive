package 인터페이스;

public class TelevisionServiceImpl implements RemoteService {
    int volume;
    int channel;

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
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
        System.out.println("TV 볼륨이 " + this.volume + "로 설정되었습니다.");
    }

    public void setChannel(int channel) {
        if(channel >= 1 && channel <= 999){
            this.channel = channel;
            System.out.println("TV 채널이 " + this.channel + "로 설정되었습니다.");
        } else {
            System.out.println("채널 번호는 1에서 999 사이여야 합니다.");
            return;
        }
    }
}
