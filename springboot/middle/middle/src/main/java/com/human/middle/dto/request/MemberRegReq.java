package com.human.middle.dto.request;

import com.human.middle.dto.Member;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberRegReq {
    private String username;
    private String password;
    private String nickname;

    public Member toEntity() {
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .nickname(this.nickname)
                .build();
    }
}
