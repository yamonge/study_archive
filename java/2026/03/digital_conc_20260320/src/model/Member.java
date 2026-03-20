package model;

public class Member {


    // TODO 1-1: static idCounter 필드 선언 (초기값 1)
    private static int idCounter = 1;
    private int    memberId;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {

        // TODO 1-2: memberId 자동 채번
        this.memberId = idCounter++;

        this.name     = name;
        this.email    = email;
        this.password = password;
    }

    // TODO 1-3: getMemberId(), getName(), getEmail(), getPassword() 구현
    public int getMemberId() {
        return memberId;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        // TODO 1-4: "[1] Alice (alice@test.com)" 형식으로 반환
        return String.format("[%d] %s (%s)", memberId, name, email);
    }


}
