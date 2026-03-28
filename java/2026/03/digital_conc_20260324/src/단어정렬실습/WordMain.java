package 단어정렬실습;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordMain {
    public static void main(String[] args) {
        Comparator<String> wordComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length(); // 길이순 정렬
                } else {
                    return s1.compareTo(s2); // 사전순 정렬
                }
            }
        };
        TreeSet<String> words = new TreeSet<>(wordComparator);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("현재 단어 목록: " + words);
            System.out.print("단어를 입력하세요 (종료하려면 'q' 입력):");
            String word = sc.nextLine().trim();
            if (word.equalsIgnoreCase("q")) {
                break;
            }else{
                words.add(word);
            }
        }
    }
}
