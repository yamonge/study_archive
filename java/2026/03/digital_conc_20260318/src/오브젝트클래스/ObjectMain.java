package 오브젝트클래스;

public class ObjectMain {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
    }
}

class Student extends Object{
    String name;
    int age;

    Student(){
        name = "곰돌이";
        age = 20;
    }
    // 원래의 toString(): 객체의 정보를 문자열로 반환(클래스명, 해시코드)
    @Override
    public String toString(){
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
