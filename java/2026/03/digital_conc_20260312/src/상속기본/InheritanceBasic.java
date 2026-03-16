package 상속기본;

public class InheritanceBasic {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        HouseDog houseDog = new HouseDog();
        dog1.setName("멍멍이");
        houseDog.setName(dog1.getName());
        System.out.println(dog1.getName());
        dog1.sleep();
        houseDog.sleep();
        houseDog.sleep(6);
    }
}

class Animal{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal{
    void sleep(){
        System.out.println(name + "가 잠을 잡니다.");
    }
}

class HouseDog extends Dog{
    @Override
    void sleep(){
        System.out.println(name + "가 집에서 잠을 잡니다.");
    }

    void sleep(int hour){
        System.out.println(name + "가 집에서 " + hour + "시간 동안 잠을 잡니다");

    }
}