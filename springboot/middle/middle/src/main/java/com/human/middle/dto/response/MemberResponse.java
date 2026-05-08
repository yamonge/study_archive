package com.human.middle.dto.response;

import com.human.middle.dto.Member;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberResponse {
    private Long memberId;
    private String username;
    private String nickname;
    private String memberRole;

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .username(member.getUsername())
                .nickname(member.getNickname())
                .memberRole(member.getMemberRole())
                .build();
    }
}
