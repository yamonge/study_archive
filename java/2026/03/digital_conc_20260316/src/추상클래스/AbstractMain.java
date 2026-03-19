package 추상클래스;

public class AbstractMain {
    public static void main(String[] args) {
        AndroidPhone phone = new AndroidPhone( "갤럭시", true);
        phone.call();
        phone.setMode(true);
        System.out.println("현재 모드 : " + phone.getMode());

        ApplePhone apple = new ApplePhone("아이폰", true);
        apple.call();
        apple.setMode(true);
        System.out.println("현재 모드 : " + apple.getMode());

    }
}
