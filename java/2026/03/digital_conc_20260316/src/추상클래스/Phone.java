package 추상클래스;

public abstract class Phone {
    private String name;
    private boolean power;
    boolean mode;

    public Phone(String name, boolean power) {
        this.name = name;
        this.power = power;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    // 통화 기능은 상속 받은 클래스에서 구현 하도록 함
    public abstract void call();
    public abstract void setMode(boolean mode);
    public abstract boolean getMode();
}
