package 스트림기본;

import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

//        for(int e : list) {
//            if(e >= 5){
//                System.out.println(e + " ");
//            }
//        }

        // stream 사용
        list.stream()
                        .filter(e -> e >= 5)
                        .forEach(e -> System.out.println(e + " "));

        System.out.println();

//        for (int e : list){
//            if(e % 2 == 0 && 3 >= 5){
//                System.out.println(e + " ");
//            }
//        }

        // stream 사용
        list.stream()
                        .filter(e -> e % 2 == 0)
                        .filter(e -> 3 >= 5)
                        .forEach(e -> System.out.println(e + " "));

        System.out.println();
    }
}
