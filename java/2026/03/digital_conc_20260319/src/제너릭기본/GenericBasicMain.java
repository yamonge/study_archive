package 제너릭기본;

import java.util.ArrayList;
import java.util.List;

public class GenericBasicMain {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("정경수");
        list1.add("안유진");
        list1.add("1004");

        for(Object name : list1){
            System.out.println(name);
        }

        Person<String> p1 = new Person("곰돌이");
        System.out.println(p1.getInfo());
        Person<Integer> p2 = new Person<>(1000);
        System.out.println(p2.getInfo());
    }
}

//
class Person<T>{
    private T info;
    public Person(T info){
        this.info = info;
    }
    public T getInfo(){
        return info;
    }
}
