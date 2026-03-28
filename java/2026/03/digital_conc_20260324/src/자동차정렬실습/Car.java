package 자동차정렬실습;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    int year;
    String name;
    int price;

    public Car(int year, String name, int price) {
        this.year = year;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Car car) {
        if (this.year != car.year) {
            return this.year - car.year; // 연식이 낮은 순으로 정렬
        }
        if (!this.name.equals(car.name)) {
            return this.name.compareTo(car.name); // 이름순으로 정렬
        }
        if(this.price != car.price){
            return this.price - car.price; // 가격이 낮은 순으로 정렬
        }
        return 0; // 같음
    }

    @Override
    public String toString(){
        return year + " " + name + " " + price;
    }
}

class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if(c1.year != c2.year){
            return c1.year - c2.year; // 연식이 낮은 순으로 정렬
        }
        return 0;
    }
}

class YearComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if(c1.year != c2.year){
            return c2.year - c1.year; // 연식이 높은 순으로 정렬
        }
        return 0;
    }
}

class NameComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if(!c1.name.equals(c2.name)){
            return c1.name.compareTo(c2.name); // 이름순으로 정렬
        }
        return 0;
    }
}

class NameComparatorDesc implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if(!c1.name.equals(c2.name)){
            return c2.name.compareTo(c1.name); // 이름순으로 정렬
        }
        return 0;
    }
}

class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        if(c1.price != c2.price){
            return c1.price - c2.price; // 가격이 낮은 순으로 정렬
        }
        return 0;
    }
}

class PriceComparatorDesc implements Comparator<Car>{
    @Override
    public int compare(Car c1, Car c2){
        if(c1.price != c2.price){
            return c2.price - c1.price;
        }
        return 0;
    }
}
