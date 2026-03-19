package 제너릭기본;

public class GenericMain {
    public static void main(String[] args) {
        GenericPrinter<Powder> printer = new GenericPrinter<>();
        printer.setMaterial(new Powder());
        Powder pw = new Powder();
        printer.setMaterial(pw);
        System.out.println(printer);


    }
}
