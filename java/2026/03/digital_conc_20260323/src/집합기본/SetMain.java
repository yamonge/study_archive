package 집합기본;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        System.out.println(set);

        Set<MemberSet> set1 = new HashSet<>();
        MemberSet member1 = new MemberSet(1001, "홍길동");
        MemberSet member2 = new MemberSet(1002, "김철수");
        MemberSet member3 = new MemberSet(1001, "홍길동");
        set1.add(member1);
        set1.add(member2);
        set1.add(member3);
        System.out.println(set1);
        System.out.println(member1.equals(member3));

    }
}
