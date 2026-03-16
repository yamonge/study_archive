package 샘플프로그램;

import 변수와자료형.User;

public class SampleMain {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("안녕하세요. 자바프로그래밍 입니다.");
        User userInfo;
        user.age = 20;
        System.out.println(user.age);
    }
}
