package 열거타입;

public class EnumMain {
    public static void main(String[] args) {
        Developer developer = new Developer("곰돌이", DevType.FRONTEND, Career.JUNIOR, Gender.MALE);
        developer.printInfo();
    }
}
