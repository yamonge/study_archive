package com.human.middle.dto.request;

import com.human.middle.dto.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRegReq {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String username;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    @NotBlank(message = "닉네임를 입력해주세요.")
    private String nickname;

    public Member toEntity() {
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .nickname(this.nickname)
                .build();
    }
}
