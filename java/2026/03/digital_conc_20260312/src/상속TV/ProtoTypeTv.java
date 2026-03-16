package 상속TV;
// 상속을 주기 위한 TV 만들기
public class ProtoTypeTv {
    //전원
    private boolean power;
    //채널
    private int channel;

    //볼륨
    private int volume;



    //생성자2개(매개변수X, 매개변수 전부)
    public ProtoTypeTv(){}
    public ProtoTypeTv(boolean power, int channel, int volume){
        this.power = power;
        this.channel = channel;
        this.volume = volume;
    }
    // 전원 설정
    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
    // 채널 설정
    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if(channel > 999 || channel < 0){
            System.out.println("잘못된 입력입니다.");
        }else{
            this.channel = channel;
        }
    }
    // 볼륨 설정
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
