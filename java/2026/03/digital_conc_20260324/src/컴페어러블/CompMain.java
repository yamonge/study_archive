package 컴페어러블;

import java.util.*;

// Comparable과 Comparator는  자바에서 객체를 정렬하는 데 사용하는 인터페이스
// Comparable은 나와 다른 객체를 비교하는 방식
// Comparator는 다른 두 객체를 비교하는 방식
public class CompMain {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Sonata", 2005, "white"));
        cars.add(new Car("Avante", 2003, "black"));
        cars.add(new Car("Grandeur", 2005, "gray"));
        cars.add(new Car("Sonata", 2005, "black"));

        Collections.sort(cars);

        System.out.println(cars);
    }
}

class Car implements Comparable<Car>{
    String name;
    int year;
    String color;

    public Car(String name, int year, String color) {
        this.name = name;
        this.year = year;
        this.color = color;
    }

    @Override
    public int compareTo(Car car) {  // 우리가 정한 정렬규칙 최신연식 기준, 연식이 같으면 차량이름
        // 연식순 정렬
        if(this.year != car.year){ // 2005 - 2003 양수
            return this.year - car.year; // 양수면 순서 바뀜
        }
        // 이름순 정렬
        if(!this.name.equals(car.name)){
            return this.name.compareTo(car.name); // 양수면 순서 바뀜
        }
        // 색상순 정렬
        if(!this.color.equals(car.color)){
            return this.color.compareTo(car.color); // 양수면 순서 바뀜
        }
        return 0; // 같음
    }

    @Override
    public String toString(){
        return name + " " + year + " " + color;
    }
}