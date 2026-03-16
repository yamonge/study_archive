package 시스템출력;
    // 자바 표준 입출력 클래스 : 사용자와 프로그램 사이의 입출력을 담당
    // 입력과 출력은 무수히 많은 장치가 있을 수 있음
    // System.in : 표준 입력 스트림, 사용자의 입력을 프로그램에 넣는 것
    // System.out : 표준 출력 스트림, 프로그램의 출력을 콘솔로 나타내는 것
    // System.err : 표준 우류 스트림, 프로그램 내에서 발생한 오류를 콘솔에 출력 할 때 사용

public class SystemOut {
    public static void main(String[] args) {
        // 표준 출력 : println(내용) 줄바꿈 포함, print(내용) 줄바꿈 없음, printf("서식", 출력값) 서식 지정자 사용
        // 이름은 문자열, 주소 문자열, 성별은 문자, 국어, 영어, 수학 성적은 정수, 총점은 정수, 평군은 실수타입
        String name = "홍길동";
        String addr = "경기도";
        char gender = 'M';
        int kor = 90, eng = 50, mat = 60;
        int total = kor + eng + mat;
        double avg = (double)total / 3;
        System.out.println(name + addr + gender);
        System.out.println("총점" + total);
        System.out.println("평균" + avg);

        System.out.printf("%s, %s, %c %n", name, addr, gender);
        System.out.printf("총점 : %d %n", total);
        System.out.printf("평균 : %.2f %n", avg);

        System.out.println("딸기\r바나나\r키위");
        System.out.println("딸기\t바나나\t키위");
        System.out.println("strawbarry\tbanana\tkiwi");
        System.out.println("strawbarry\bbanana\bkiwi");
        System.out.println("strawbarry\\banana\\kiwi");

        System.out.printf("이름 : %s\n", name);
        System.out.printf("주소 : %s\n", addr);
        System.out.printf("성별 : %c\n", gender);
        System.out.printf("총점 : %d\n", total);
        System.out.printf("평균 : %.2f\n", avg);

        // println(), print() : 오버로딩 : 메서드의 매개변수의 개수나 타입으로 호출할 매서드를 결정
        System.out.println("이름 : " + name);
        System.out.println("주소 : " + addr);
        System.out.println("성별 : " + (gender == 'M' ? "남성" : "여성"));
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + avg);

        System.out.println("JDK" + 17 + 8);
        System.out.println(17 + 8 + "JDK");
    }
}
