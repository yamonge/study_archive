package com.ex.spring_jap_board.dto.response;

import com.ex.spring_jap_board.entity.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberRes {
    private Long memberId;
    private String memberName;
    private String memberImgUrl;

    public static MemberRes of(Member member){
        MemberRes memberRes = new MemberRes();
        memberRes.setMemberId(member.getMemberId());
        memberRes.setMemberName(member.getMemberName());
        memberRes.setMemberImgUrl(member.getMemberImgUrl());
        return memberRes;
    }
}
