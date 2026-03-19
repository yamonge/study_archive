package 제너릭기본;

public class GenericFuncMain {
    public static void main(String[] args) {
        GenericFunc<Oil> gf = new GenericFunc<>();
        gf.setMat(new Oil());
        Oil oil = gf.getMat();
        oil.setOil(10);
        gf.getMat().setOil(10);
    }
}
