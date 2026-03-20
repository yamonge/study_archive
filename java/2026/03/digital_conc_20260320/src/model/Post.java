package model;

public class Post {
    private static int idCounter = 1;
    private int postId;
    private int memberId;
    private String memberName;
    private String title;
    private String content;

    public Post(int memberId, String memberName, String title, String content) {
        this.postId = idCounter++;
        this.memberId = memberId;
        this.memberName = memberName;
        this.title = title;
        this.content = content;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Post.idCounter = idCounter;
    }

    public int getPostId() {
        return postId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    @Override
    public String toString() {
        return String.format("[%d] %s (작성자 : %s)", postId, title, memberName);
    }
}