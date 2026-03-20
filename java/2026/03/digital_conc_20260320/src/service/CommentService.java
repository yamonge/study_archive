package service;

import model.Comment;
import model.Member;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private List<Comment> comments = new ArrayList<>();

    public Comment write(int postId, Member author, String content) {
        int commentId = Comment.getCommentIdCounter() + 1;
        Comment comment = new Comment(commentId, postId, author.getMemberId(), author.getName(), content);
        comments.add(comment);
        Comment.setCommentIdCounter(commentId);
        return comment;
    }

    public void listByPost(int postId) {
        for (Comment comment : comments) {
            if (comment.getPostId() == postId) {
                System.out.println(comment);
            }
        }
    }

    public boolean delete(int commentId, Member member) {
        for (Comment comment : comments) {
            if (comment.getCommentId() == commentId && comment.getMemberId() == member.getMemberId()) {
                comments.remove(comment);
                return true;
            }
        }
        return false;
    }
}
