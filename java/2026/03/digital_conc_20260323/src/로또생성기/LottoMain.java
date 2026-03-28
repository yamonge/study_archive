package 로또생성기;

import java.util.*;

// 1 ~ 45 사이의 중복되지 않는 6개의 숫자를 생성하는 프로그램 ArrayList사용
// 1 ~ 45 사이의 중복되지 않는 6개의 숫자를 생성하는 프로그램 HashSet사용
public class LottoMain {
    private static final List<Integer> ar = new ArrayList<>();
    private static final Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        while (true) {
            System.out.println("로또 번호 생성기");
            System.out.println("1. ArrayList 사용");
            System.out.println("2. HashSet 사용");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    lottoArrayList();
                    break;
                case 2:
                    lottoHashSet();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    public static void lottoArrayList(){
        ar.clear();
        while(true){
            int num = (int)(Math.random() * 45 + 1);
            if(!ar.contains(num)){
                ar.add(num);
            }
            if(ar.size() == 6){
                break;
            }
        }
        Collections.sort(ar);
        System.out.println(ar);
    }

    public static void lottoHashSet(){
        set.clear();
        while(true){
            int num = (int)(Math.random() * 45 + 1);
            if(set.size() == 6){
                break;
            }else{
                set.add(num);
            }
        }
        List<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);
        System.out.println(sortedSet);
    }
}
