package 주사위게임;

public class Dice {
    private int num;

    public Dice(){

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void roll(){
        int rand = (int)(Math.random() * 6 + 1);
        this.num = rand;
    }
}
