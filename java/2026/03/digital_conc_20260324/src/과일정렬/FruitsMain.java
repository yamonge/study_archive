package 과일정렬;
// Comparator 인터페이스를 사용하여 과일 객체를 정렬하는 프로그램 작성
// Comparator은 Comparable과 달리 자신과 비교하는게 아님

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class FruitsMain {
    public static void main(String[] args) {
        TreeSet<Fruit> fruits = new TreeSet<>(new Fruit("", 0)); // Comparator를 구현한 객체를 TreeSet 생성자에 전달
        fruits.add(new Fruit("Apple", 150));
        fruits.add(new Fruit("Banana", 100));
        fruits.add(new Fruit("Cherry", 150));
        fruits.add(new Fruit("Date", 120));

        System.out.println(fruits);

    }
}

class Fruit implements Comparator<Fruit> {
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

    @Override
    public int compare(Fruit f1, Fruit f2) {
        if (f1.price != f2.price) {
            return f1.price - f2.price; // 가격이 낮은 순으로 정렬
        } else {
            return f1.name.compareTo(f2.name); // 이름순으로 정렬
        }
    }
}
