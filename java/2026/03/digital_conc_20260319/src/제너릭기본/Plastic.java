package 제너릭기본;

public class Plastic extends Material{
    public void doPrinting(){
        System.out.println("플라스틱 재료로 출력합니다.");
    }
    @Override
    public String toString(){
        return "플라스틱 입니다.";
    }

    @Override
    public void doPrint() {

    }
}
