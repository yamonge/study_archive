package 학생성적정렬;

public class Student implements Comparable<Student> {
    String name;
    int korean;
    int english;
    int math;
    int total;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.total = korean + english + math;
    }

    @Override
    public int compareTo(Student student) {
        if(this.total != student.total){
            return this.total - student.total; // 총점이 높은 순으로 정렬
        }else{
            return this.name.compareTo(student.name); // 이름순으로 정렬
        }
    }

    @Override
    public String toString(){
        return name + " " + total;
    }
}
