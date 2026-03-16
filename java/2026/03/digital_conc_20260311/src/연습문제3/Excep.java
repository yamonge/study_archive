package 연습문제3;

import java.util.InputMismatchException;

public class Excep {
    public Excep(){

    }

    public int num(String num, int max){
        boolean isNumber = true;

        for(int i = 0; i < num.length(); i++){
            if(!Character.isDigit(num.charAt(i))){
                isNumber = false;
                break;
            }
        }

        if(!isNumber){
            return -1;
        }else{
            int number = Integer.parseInt(num);
            if(number > max){
                return -1;
            }
            return number;
        }
    }
}
