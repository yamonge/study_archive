package 트리셋;

import java.util.TreeSet;

// 요소가 자동으로 정렬됨
// 중복 허용 하지  않음
// 삽입 삭제 검색 : 0(log n)
// 중위 순회 시 오름차순 출력 가능
public class TreeSetMain {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(23);
        treeSet.add(45);
        treeSet.add(12);
        treeSet.add(56);
        treeSet.add(34);
        treeSet.add(45); // 중복 허용 안됨

        for(int e: treeSet){

        }
    }
}
