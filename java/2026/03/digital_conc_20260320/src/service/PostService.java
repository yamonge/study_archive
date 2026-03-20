package service;

import model.Member;
import model.Post;
import java.util.ArrayList;

public class PostService {
    private ArrayList<Post> posts = new ArrayList<>();
    public Post write(Member author, String title, String content) {
        Post newPost = new Post(author.getMemberId(), author.getName(), title, content);
        posts.add(newPost);
        System.out.println("게시글이 작성이 완료되었습니다.");
        return newPost;
    }
    public void listAll() {
        if (posts.isEmpty()) {
            System.out.println("등록된 게시글이 없습니다.");
        } else {
            for (Post p : posts) {
                System.out.println(p.toString());
            }
        }
    }
    public Post findById(int postId) {
        for (Post p : posts) {
            if (p.getPostId() == postId) {
                return p;
            }
        }
        return null;
    }
    public boolean delete(int postId, Member loginMember) {
        Post post = findById(postId);
        if (post == null) {
            System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
            return false;
        }
        if (post.getMemberId() != loginMember.getMemberId()) {
            System.out.println("삭제 권한이 없습니다. (작성자 본인만 삭제 가능)");
            return false;
        }
        posts.remove(post);
        System.out.println(postId + "번 게시글이 삭제되었습니다.");
        return true;
    }
}
