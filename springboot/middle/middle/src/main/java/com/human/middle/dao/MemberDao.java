package com.human.middle.dao;

import com.human.middle.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor    // final 필드의 생성자를 자동으로 만들어줌
public class MemberDao {
     private final JdbcTemplate jdbcTemplate; // 생성자를 통한 의존성 주입 사용을 하지않으면 아래처럼 작성
    //    private JdbcTemplate jdbcTemplate;
    //    MemberDao(JdbcTemplate jdbcTemplate){
    //        this.jdbcTemplate = jdbcTemplate;
    //    }

     // 회원가입
     public boolean save(Member member){
          String sql = "INSERT INTO member (member_id, username, password, nickname) VALUES (members_seq.NEXTVAL, ?,?,?)";
          int rst = jdbcTemplate.update(sql, member.getUsername(), member.getPassword(), member.getNickname());
          return rst > 0;
     }

     // 회원가입 여부 확인
     public boolean isDuplicate(String username){
          String sql = "SELECT COUNT(*) FROM member WHERE username =?";
          int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
          return count > 0;
     }

     // 로그인
     public Member login(String username){
          String sql = "SELECT * FROM member WHERE username = ?";
          Member member = jdbcTemplate.queryForObject(sql, Member.class, username);
          return member;
     }

     // 전체 멤버 조회
     public List<Member> showall(){
          String sql = "SELECT * FROM member";
          List<Member> members = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));
          return members;
     }

     // 멤버 조회 ID로
     public Optional<Member> userInfo(Long memberId){
          String sql = "SELECT * FROM member where member_id = ?";
          List<Member> members = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class), memberId);
          return members.stream().findFirst();
     }

     // 멤버 조회 이름으로
     public Optional<Member> userInfo(String username){
          String sql = "SELECT * FROM member where username = ?";
          List<Member> members = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Member.class), username);
          return members.stream().findFirst();
     }
}
