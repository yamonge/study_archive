package 도서관리시스템;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BookHashSetTest {
    public static void main(String[] args) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book(101, "자바의 정석", "남궁성"));
        bookSet.add(new Book(102, "클린코드", "로버트 마틴"));
        bookSet.add(new Book(103, "운영체제", "공룡책"));
        bookSet.add(new Book(103, "리팩터링", "마틴 파울러"));
        System.out.println(bookSet);

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4,5,6,7,8));

        // 교집합
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);
        // 합집합
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);
        // 차집합
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합: " + difference);

    }
}
