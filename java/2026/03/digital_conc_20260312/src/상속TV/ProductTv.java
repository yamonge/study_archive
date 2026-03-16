package 상속TV;

public class ProductTv extends ProtoTypeTv{
    private String name;
    private boolean isSmart;

    public ProductTv(){}

    public ProductTv(boolean power, int channel, int volume, String name){
        super(power, channel, volume);
        this.name = name;
        isSmart = false;
    }

    public void checkVolume(){
        if(getVolume() > 100 || getVolume() < 0){
            System.out.println("잘못된 입력입니다.");
        }
    }

    @Override
    public void setChannel(int channel) {
        if(channel  > 1999 || channel < 0) {
            System.out.println("잘못된 입력입니다.");
        }else{
           super.setChannel(channel);
        }
    }

    public void setIsSmart(boolean isSmart){
        this.isSmart = isSmart;
    }

}
