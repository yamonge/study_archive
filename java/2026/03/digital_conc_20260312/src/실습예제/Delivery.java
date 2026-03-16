package 실습예제;

public class Delivery {
    String company;
    
    void delivery(){
        System.out.println("배송을 시작합니다.");
    }
}

class ParcelDelivery extends Delivery{
    @Override
    void delivery(){
        System.out.println("택배 배송을 시작합니다. 2~3일 소요됩니다.");
    }
}

class QuickDelivery extends Delivery{
    @Override
    void delivery(){
        System.out.println("퀵 배송을 시작합니다. 당일 도착 예정입니다.");
    }
}

class AirDelivery extends Delivery{
    @Override
    void delivery(){
        System.out.println("항공 배송을 시작합니다. 해외로 출발합니다.");
    }
}

class Manager{
    void send(Delivery delivery){
        System.out.println("회사가 배송을 시작합니다.");
        delivery.delivery();
    }

}