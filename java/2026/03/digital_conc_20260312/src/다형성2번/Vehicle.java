package 다형성2번;

public class Vehicle {
    public void move(){
            System.out.println("차량이 달립니다.");
    }
    public void move(int speed){
        System.out.printf("차량이 시속 %dKM 로 달립니다.", speed);
    }
}

class Bus extends Vehicle{
    @Override
    public void move() {
        System.out.println("버스가 달립니다.");
    }

    public void move(int speed){
        System.out.println("버스가 시속 " + speed + "KM 로 달립니다.");
    }
}

class Taxi extends Vehicle{
    @Override
    public void move() {
        System.out.println("택시가 달립니다.");
    }
    public void move(int speed){
        System.out.println("택시가 시속 " + speed + "KM 로 달립니다.");
    }
}

class SportCar extends Vehicle{
    @Override
    public void move() {
        System.out.println("스포츠카가 달립니다.");
    }
    public void move(int speed){
        System.out.println("스포츠카가 시속 " + speed + "KM 로 달립니다.");
    }
}

class Driver{
    String name;
    public Driver(String name){
        this.name = name;
    }

    void drive(Vehicle vehicle, int speed){
        System.out.println(name + "이(가) 운전합니다.");
        vehicle.move();
        vehicle.move(speed);
    }
}
