package 추상클래스;

public class AndroidPhone extends Phone{
    public AndroidPhone (String name, boolean power) {
        super(name, power);
    }

    @Override
    public void call() {
        System.out.println("추상 메서드를 상속 받아서 자식 클래스에서 Call 기능 구현");
    }

    @Override
    public void setMode(boolean mode) {
        if(mode){
            System.out.println("구글 스토어 기능을 활성화 합니다");
            this.mode = true;
        }else{
            System.out.println("구글 스토어 기능을 비활성화 합니다");
            this.mode = false;
        }

    }

    @Override
    public boolean getMode() {
        return this.mode;
    }
}
