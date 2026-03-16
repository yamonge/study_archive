package 매개변수의다형성;

public class Product {
    int price;
    int bonusPoint;
}

class Tv extends Product{
    public Tv(){
        this.price = 100;
        this.bonusPoint = 10;
    }
}

class Phone extends Product{
    public Phone(){
        this.price = 200;
        this.bonusPoint = 20;
    }
}

class Computer extends Product{
    public Computer(){
        this.price = 300;
        this.bonusPoint = 30;
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    void buy(Product product){
        if(bonusPoint > product.price){
            bonusPoint -= product.price;
            return;
        }
        if(money <= 0 || money < product.price){
            System.out.println("잔액이 부족합니다.");
        }else{
            money -= product.price;
            bonusPoint += product.bonusPoint;
            System.out.println("남은잔액: " + money);
            System.out.println("적립 포인트: " + bonusPoint);
        }
    }
    void printInfo(){
        System.out.println("잔액: " + money);
        System.out.println("포인트: " + bonusPoint);
    }
}
