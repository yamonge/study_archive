package 비트연산자;

public class BitOperatorMain {
    public static void main(String[] args) {
        int x = 10, y = 12;
        System.out.println(x & y); // 비트AND 둘다 1
        System.out.println(x | y); // 비트OR 둘중 하나만 1
        System.out.println(x ^ y); // 비트XOR 서로 다를때
        System.out.println(~x); // 비트NOT 비트 반전
        System.out.println(x << 1);
        System.out.println(x >> 1);
    }
}
