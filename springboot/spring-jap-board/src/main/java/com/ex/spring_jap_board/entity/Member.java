package com.ex.spring_jap_board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity // 이 클래스가 jpa 엔티티 임을 나타냄
@Table(name = "member") // 테이블 이름 정함 지정하지않을시 camelCase 문법으로 클래스이름이 들어감 굳이 안해도됨
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"memberPwd"})
public class Member {
    @Id //PK 역할, JPA에서는 반드시 있어야함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 생성 전략을 DB에 위임 pk값 +1 자동을 넘김
    @Column(name = "member_id") // db속 테이블 안 컬럼 이름 지정
    private Long memberId;

    @Column(unique = true, length = 150, name = "member_email")
    private String memberEmail;

    @Column(nullable = false, name = "member_pwd")
    private String memberPwd;

    @Column(nullable = false, length = 30, name="member_name")
    private String memberName;

    @Column(length = 255, name = "member_img_url")
    private String memberImgUrl;

    @Column(nullable = false, length = 30)
    private String memberRole;

    private LocalDateTime memberCreatedAt;

    @PrePersist // DB에 INSERT 되기 직전에 자동 호출 되는 메서드
    public void prePersist(){
        memberCreatedAt = LocalDateTime.now(); // 현재 날짜와 시간을 자동으로 기록
    }
}
