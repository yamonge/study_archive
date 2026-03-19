package 정렬실습;
// 임의의 0개의 과일이름 입력 후 길이 순으로 정렬하기, 길이가 같으면 사전순으로 정렬하기
// 반환값 0 : 두 객체가 같음을 의미
// 양수 : 정렬 조건
// 음수 : 현상태유지

// compareTo() : 사전순 정렬에서 사용
// 0 : 두개체가 같다는 의미
// 양수 : 첫 번째 객체가 두번째 객체보다 크다는 의미
// 음수 : 첫 번째 객체가 두번째 객체보다 작다는 의미


import java.util.*;

public class SortEx1 {
    public static void main(String[] args) {
        // 문자열 배열을 만들기(입력)
        Scanner sc = new Scanner(System.in);
        List<String> fruits = new ArrayList<>();
        while(true){
            System.out.print("과일을 입력해주세요(0입력시 종료): ");
            String fruit = sc.nextLine();
            if(fruit.equals("0")){
                break;
            }
            fruits.add(fruit);
        }
        // arrays.sort override 길이정렬 먼저 같으면 사전순 정렬
        fruits.sort(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()){
                    return 1;
                }else if(s1.length() < s2.length()){
                    return -1;
                }
                return s1.compareTo(s2);
            }
        });
        // 출력
        System.out.println(fruits);
    }
}

