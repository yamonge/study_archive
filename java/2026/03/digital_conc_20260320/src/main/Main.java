package main;

import model.Comment;
import model.Member;
import model.Post;
import service.CommentService;
import service.MemberService;
import service.PostService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static CommentService commentService = new CommentService();
    private static MemberService memberService = new MemberService();
    private static PostService postService = new PostService();
    private static Member loginMember = null; // 로그인한 회원 정보 저장용

    public static void main(String[] args) {
        while (true) {
            // 실행 로직
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }
            switch (choice) {
                case 1:
                    // 회원 가입
                    printJoin();
                    break;
                case 2:
                    // 로그인
                    printLogin();
                    break;
                case 3:
                    // 게시글 작성
                    printWritePost();
                    break;
                case 4:
                    // 게시글 목록 보기
                    printPostList();
                    printPostListInput();
                    break;
                case 5:
                    // 회원 목록 보기
                    printMemberList();
                    printMemberListInput();
                    break;
            }
        }
    }
    public static void printMenu () {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     ★  Java Community BBS v1.0  ★       ║");
        System.out.println("║      ArrayList × OOP 실습 프로젝트          ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│        [ 메 인 메 뉴 ]        │");
        System.out.println("├─────────────────────────────┤");
        if(loginMember == null) {
            System.out.println("│  1. 회원 가입               │");
            System.out.println("│  2. 로그인                  │");
        } else {
            System.out.println("│  " + loginMember.getName() + "님 환영합니다!       │");
        }
        System.out.println("│  3. 게시글 작성               │");
        System.out.println("│  4. 게시글 목록 보기           │");
        System.out.println("│  5. 회원 목록 보기           │");
        System.out.println("│  0. 종료                     │");
        System.out.println("└─────────────────────────────┘");
        System.out.print("▶ 선택 : ");
    }

    // 회원가입
    public static void printJoin () {
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.print("이메일을 입력하세요: ");
        String email = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();
        memberService.join(name, email, password);
    }

    // 로그인
    public static void printLogin () {
        System.out.print("이메일을 입력하세요: ");
        String email = sc.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = sc.nextLine();
        loginMember = memberService.login(email, password);
    }

    // 게시글 작성
    public static void printWritePost () {
        if(loginMember == null){
            System.out.println("로그인이 필요한 기능입니다. 로그인 후 이용해주세요.");
            return;
        }else{
            System.out.print("게시글 제목을 입력하세요: ");
            String title = sc.nextLine();
            System.out.print("게시글 내용을 입력하세요: ");
            String content = sc.nextLine();
            postService.write(loginMember, title, content);
        }
    }

    // 게시글 목록 보기
    public static void printPostList () {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│        [ 게 시 글 목 록 ]       │");
        System.out.println("├─────────────────────────────┤");
        postService.listAll();
        System.out.println("│  0. 뒤로 가기                 │");
        System.out.println("└─────────────────────────────┘");
        System.out.print("▶ 선택 : ");
    }

    // 게시글 상세보기 입력 프린트
    public static void printPostListInput () {
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 0) {
            return;
        }
        if(Post.getIdCounter() < choice || choice < 1) {
            System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            return;
        }
        Post selectedPost = postService.findById(choice);
        printPostDetail(selectedPost);
    }



    // 게시글 상세 보기
    public static void printPostDetail (Post post){
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│  " + post + "    │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│  " + post.getContent() + "    │");
        commentService.listByPost(post.getPostId());
        System.out.println("│ 1. 댓글 작성                 │");
        System.out.println("│ 2. 댓글 삭제                 │");
        System.out.println("│ 3. 게시글 삭제               │");
        System.out.println("│ 0. 뒤로 가기                 │");
        System.out.println("└─────────────────────────────┘");
        System.out.print("▶ 선택 : ");
        printPostDetailInput(post);
    }

    // 게시글 상세 보기 입력
    public static void printPostDetailInput (Post post){
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("댓글 내용을 입력하세요: ");
                String content = sc.nextLine();
                commentService.write(post.getPostId(), loginMember, content);
                break;
            case 2:
                System.out.print("삭제할 댓글 번호를 입력하세요: ");
                int commentId = sc.nextInt();
                if (commentService.delete(commentId, loginMember)) {
                    System.out.println("댓글이 삭제되었습니다.");
                } else {
                    System.out.println("댓글 삭제에 실패했습니다. 권한이 없거나 댓글이 존재하지 않습니다.");
                }
                break;
            case 3:
                postService.delete(post.getPostId(), loginMember);
                break;
            case 0:
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
        }
    }

    // 회원 목록 보기
    public static void printMemberList () {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│        [ 회 원 목 록 ]       │");
        System.out.println("├─────────────────────────────┤");
        memberService.listAll();
        System.out.println("│                             │");
        System.out.println("└─────────────────────────────┘");
        System.out.print("▶ 아무 입력 선택시 뒤로가기 : ");
    }

    // 회원 목록 보기 입력
    public static void printMemberListInput () {
        String choice = sc.nextLine();
    }

    // 숫자 검사로직

}
