package 학생성적정렬;

import java.util.TreeSet;

// 학생 객체 기준으로 성적을 정렬하는 프로그램 작성
// 성적이 같으면 이름순으로 정렬
// 성적은 국어 영어 수학 성적을 입력받아 총점을 구하고 총점 기준으로 정렬
// 필드 : 이름, 국어, 영어, 수학, 총점
// 출력 : 이름, 총점
public class StudentMain {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("홍길동", 90, 80, 70));
        students.add(new Student("김철수", 80, 80, 70));
        students.add(new Student("이영희", 90, 80, 70));
        students.add(new Student("박영수", 70, 70, 70));
        students.add(new Student("최민수", 60, 70, 70));

        System.out.println(students);
    }
}
