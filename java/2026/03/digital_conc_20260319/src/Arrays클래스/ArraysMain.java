package Arrays클래스;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysMain {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 4, 7, 8, 9, 2, 99, 300, 450, 999, 1};
        Arrays.sort(arr);
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 999));

        // 정렬 조건 오버라이딩
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2) return 1;
                else if (o1 < o2) return -1;
                else return 0;
            }
        });

        System.out.println(Arrays.toString(arr));


    }
}
