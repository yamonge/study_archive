package 어레이리스트;

import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("C#");
        list.add("JavaScripts");

        for (String lang : list){
            System.out.println(lang);
        }

        list.remove(2);

        for (String lang : list){
            System.out.println(lang);
        }

        System.out.println(list.size());

        System.out.println(list.contains("Java"));


    }
}
