package 연습문제1;

public class Decimal {
    public Decimal(){

    }

    public void num(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                count += 1;
            }
        }
        if(count == 2){
            System.out.printf("%d는 소수 입니다.", number);
        }else{
            System.out.printf("%d는 소수가 아닙니다.", number);
        }
    }
}
