package 매개변수의다양성;


class myCalc{
    public int sum(Calc c) {
        return c.sum();
    }
}
@FunctionalInterface
interface Calc {
    int sum();
}

public class LambdaEx {
    public static void main(String[] args) {
        myCalc calc = new myCalc();
        int a = 1, b = 2;

        int rst = calc.sum(() -> a + b);
        System.out.println(rst);

    }
}
