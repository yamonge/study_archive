package com.human.middle.dto;

// Service <-> DAO 사이에서 사용

import lombok.*;

//@Getter      // Getter 자동 생성
//@Setter      // Setter 자동 생성
//@ToString    // ToString을 오버라이딩
//@EqualsAndHashCode // equals()와 hashCode() 오버라이딩
//@RequiredArgsConstructor  // final 필드 생성자
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long memberId;
    private String username;
    private String password;
    private String nickname;
    private String memberRole;

    @Builder
    public Member(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}

