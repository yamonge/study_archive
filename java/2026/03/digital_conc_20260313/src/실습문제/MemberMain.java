package 실습문제;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Member> members = new ArrayList<>();
        while (true) {
            System.out.println("[1]회원가입  [2]로그인  [3]전체회원조회  [4]회원삭제  [5]총 회원수  [6]종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("이름을 입력하세요: ");
                    String name = sc.next();
                    System.out.print("아이디를 입력하세요: ");
                    String userId = sc.next();
                    System.out.print("비밀번호를 입력하세요: ");
                    String password = sc.next();
                    System.out.print("나이를 입력하세요: ");
                    int age = sc.nextInt();
                    boolean isDuplicate = false;
                    for (Member m : members) {
                        if (m.getUserId().equals(userId)) {
                            isDuplicate = true;
                            System.out.println("이미 사용중인 아이디 입니다.");
                            break;
                        }
                    }
                    if(!isDuplicate){
                        members.add(new Member(name, userId, password, age));
                        System.out.println("회원가입이 완료되었습니다.");
                    }
                    break;
                case 2:
                    if (members.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다. 회원가입을 해주세요.");
                        break;
                    }
                    System.out.print("아이디를 입력하세요: ");
                    String loginUserId = sc.next();
                    System.out.print("비밀번호를 입력하세요: ");
                    String loginPassword = sc.next();
                    boolean foundLogin = false;
                    for (Member m : members) {
                        if (m.login(loginUserId, loginPassword)) {
                            foundLogin = true;
                            break;
                        }
                    }
                    if (!foundLogin) {
                        break;
                    }else{
                        Member loggedInMember = null;
                        for (Member m : members) {
                            if (m.getUserId().equals(loginUserId)) {
                                loggedInMember = m;
                                break;
                            }
                        }
                        while(true){
                            System.out.println("[1]내 정보보기 [2]정보수정 [3]비밀번호 변경 [4]로그아웃");
                            System.out.print("선택: ");
                            int loginChoice = sc.nextInt();
                            boolean isLooggout = false;
                            switch (loginChoice) {
                                case 1:
                                    loggedInMember.printInfo();
                                    break;
                                case 2:
                                    System.out.print("새 이름을 입력하세요: ");
                                    String newName = sc.next();
                                    System.out.print("새 나이를 입력하세요: ");
                                    int newAge = sc.nextInt();
                                    loggedInMember.updateProfile(newName, newAge);
                                    break;
                                case 3:
                                    System.out.print("현재 비밀번호를 입력하세요: ");
                                    String oldPassword = sc.next();
                                    System.out.print("새 비밀번호를 입력하세요: ");
                                    String newPassword = sc.next();
                                    loggedInMember.changePassword(oldPassword, newPassword);
                                    break;
                                case 4:
                                    System.out.println("로그아웃되었습니다.");
                                    isLooggout = true;
                                    break;
                                default:
                                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                            }
                            if(isLooggout){
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (members.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다.");
                        break;
                    }
                    for (Member m : members) {
                        System.out.printf("회원번호: %d | 이름: %s | 아이디: %s | 나이: %d\n", m.getId(), m.getName(), m.getUserId(), m.getAge());
                    }
                    break;
                case 4:
                    if (members.isEmpty()) {
                        System.out.println("회원이 존재하지 않습니다.");
                        break;
                    }
                    System.out.print("삭제할 회원의 아이디를 입력하세요: ");
                    String deleteUserId = sc.next();
                    boolean foundDelete = false;
                    for (Member m : members) {
                        if (m.getUserId().equals(deleteUserId)) {
                            members.remove(m);
                            foundDelete = true;
                            System.out.println("회원이 삭제되었습니다.");
                            Member.deleteAccount();
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
                    }
                    break;
                case 5:
                    System.out.printf("총 회원 수: %d\n", Member.getCount());
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
            }
        }

    }
}
