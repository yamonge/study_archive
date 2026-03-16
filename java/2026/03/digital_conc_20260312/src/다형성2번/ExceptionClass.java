package 다형성2번;

public class ExceptionClass {
    public int number(String number, int max){
        try {
            int num = Integer.parseInt(number);
            if(num > max || num < 0){
                System.out.println("허용범위가 아닙니다");
                return -1;
            }
            return num;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return -1;
        }
    }
}
