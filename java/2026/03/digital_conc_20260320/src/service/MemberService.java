package service;

import model.Member;

import java.util.ArrayList;

public class MemberService {
    private ArrayList<Member> members = new ArrayList<>();

    public Member join (String name, String email, String password) {


        //TODO 2-1: for-each로 members 순회하며 이메일 중복 체크
        for (Member m : members) {
            if (m.getEmail().equals(email)) {
                System.out.println("이미 사용중인 이메일입니다");
                return null;
            }
        }

        // TODO 2-2: Member 생성 → 리스트 추가 → 완료 메시지 출력 → 반환
        Member newMember = new Member(name, email, password);
        members.add(newMember);
        System.out.println("회원가입완료: " + newMember);
        return newMember;
    }
    public void listAll() {
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다");
            return;
        }
        System.out.println("|=== 회원 목록 (" + members.size() + "명) ===|");
        for (Member m : members)
            System.out.println(m);
    }

    public Member findById(int memberId) {
        for (Member m : members)
            if (m.getMemberId() == memberId)
                return m;
        return null;
    }

    public Member login(String email, String password) {

        // TODO 3-1: for-each로 members 순회하며 이메일+비밀번호 동시 비교
        for (Member m : members) {
            String name = "";
            if (m.getEmail().equals(email) && m.getPassword().equals(password)) {
                System.out.println("로그인성공: " + m.getName() + "님 환영합니다!");
                return m;
            }
        }
        // TODO 3-2: 못 찾은 경우 실패 메시지 출력 후 null 반환
        System.out.println("이메일 또는 비밀번호가 틀렸습니다");
        return null;
    }
}