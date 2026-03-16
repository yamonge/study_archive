package 연습문제2;

import java.util.List;

public class MovieTicket {
    private final int[] seats = new int[10];
    int price;
    int totalAmount;

    public MovieTicket(int price){
        this.price = price;
    }

    public void printSeat(){
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                System.out.print("[ ] ");
            }else{
                System.out.print("[V] ");
            }
        }
        System.out.println();
    }

    public boolean selectSeat(int num){
        if(seats[num - 1] == 1){
            System.out.println("이미 예매된 좌석입니다.");
            return false;
        }else{
            seats[num - 1] = 1;
            totalAmount += price;
            System.out.println("좌석이 예매 되어있습니다.");
            return true;
        }
    }

    public boolean cancelSeat(int num){
        if(seats[num - 1] == 1){
            seats[num - 1] = 0;
            totalAmount -= price;
            System.out.println("좌석 예메가 취소 되었습니다.");
            return true;
        }else{
            System.out.println("이미 빈 좌석 입니다.");
            return false;
        }
    }

    public int getTotalAmount(){
        return totalAmount;
    }

}
