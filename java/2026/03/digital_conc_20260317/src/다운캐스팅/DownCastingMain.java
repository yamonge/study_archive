package 다운캐스팅;

import java.util.ArrayList;

public class DownCastingMain {
    public static void main(String[] args) {
        ArrayList<Animal> ar = new ArrayList<>();
        AnimalManager am = new AnimalManager();
        ar = am.addAnimal(ar);
        for (Animal a : ar) {
            a.move();
            if (a instanceof Human) {
                Human h = (Human) a;
                h.readBook();
            } else if (a instanceof Tiger) {
                Tiger t = (Tiger) a;
                t.hunting();
            } else if (a instanceof Eagle) {
                Eagle e = (Eagle) a;
                e.flying();
            } else {
                System.out.println("지원되지 않는 타입입니다.");
            }
        }
    }
}
class Animal{
    public void move()  {
     System.out.println("동물이 움직입니다.");
    }
}

class Human extends Animal{
    @Override
    public void move() {
        System.out.println("사람이 걷습니다.");
    }
    public void readBook() {
        System.out.println("사람이 책을 읽습니다.");
    }
}

class Tiger extends Animal{
    @Override
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }
    public void hunting() {
        System.out.println("호랑이가 사냥을 합니다.");
    }
}

class Eagle extends Animal{
    @Override
    public void move() {
        System.out.println("독수리가 하늘을 날아갑니다.");
    }
    public void flying() {
        System.out.println("독수리가 양 날개를 쭉 펴고 멀리 날아갑니다.");
    }
}