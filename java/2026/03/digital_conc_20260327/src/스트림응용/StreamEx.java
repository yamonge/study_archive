package 스트림응용;

import java.util.ArrayList;
import java.util.List;

public class StreamEx {
    public static void main(String[] args) {
        List<travelCustomer> list = new ArrayList<>();
        travelCustomer c1 = new travelCustomer("홍길동", 20, 1000);
        travelCustomer c2 = new travelCustomer("김길동", 30, 2000);
        travelCustomer c3 = new travelCustomer("박길동", 40, 3000);
        travelCustomer c4 = new travelCustomer("최길동", 50, 4000);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        list.stream()
                .map(travelCustomer::getName)
                .sorted()
                .forEach(System.out::println);

        int total = list.stream()
                .mapToInt(travelCustomer::getPrice)
                .sum();
        System.out.println("총 가격 : " + total);

        list.stream()
                .filter(e -> e.getAge() >= 20)
                .map(travelCustomer::getName)
                .sorted()
                .forEach(System.out::println);

    }
}

class travelCustomer{
    private String name;
    private int age;
    private int price;

    public travelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }
}


