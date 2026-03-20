package model;

public class Comment {
    private static int commentIdCounter = 0;
    private int commentId = 0;
    private int postId;
    private int memberId;
    private String memberName;
    private String content;

    public Comment(int commentId ,int postId, int memberId, String memberName, String content) {
        this.commentId = commentId;
        this.postId = postId;
        this.memberId = memberId;
        this.memberName = memberName;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("│ └ [댓글%d] %s - %s           │", commentId, memberName, content);
    }

    public static int getCommentIdCounter() {
        return commentIdCounter;
    }

    public static void setCommentIdCounter(int commentIdCounter) {
        Comment.commentIdCounter = commentIdCounter;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
