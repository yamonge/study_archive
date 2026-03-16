package 상속TV;

public class Exp {

    public int num(String number, int max){
        for(int i = 0; i < number.length(); i++){
            if(!Character.isDigit(number.charAt(i))) {
                System.out.println("숫자만 입력해주세요.");
                return -1;
            }
        }
        int rst = Integer.parseInt(number);
        if(rst > max || rst < 0){
            System.out.println("허용범위가 아닙니다");
            return -1;
        }
        return rst;
    }
}
