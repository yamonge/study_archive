package 제너릭기본;

public class Powder extends Material {
    public void doPrinting(){
        System.out.println("파우더 재료로 출력합니다.");
    }
    @Override
    public String toString(){
        return "파우더 입니다.";
    }

    @Override
    public void doPrint() {

    }

}
