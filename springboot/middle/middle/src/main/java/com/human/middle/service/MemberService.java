package com.human.middle.service;

import com.human.middle.dao.MemberDao;
import com.human.middle.dto.Board;
import com.human.middle.dto.CustomUser;
import com.human.middle.dto.Member;
import com.human.middle.dto.request.LoginReq;
import com.human.middle.dto.request.MemberRegReq;
import com.human.middle.dto.request.UserReq;
import com.human.middle.dto.response.MemberResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(MemberRegReq req){
        if(memberDao.isDuplicate(req.getUsername())){
            throw new IllegalArgumentException("이미 사용중인 ID 입니다.");
        }
        Member member = req.toEntity();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        boolean saved = memberDao.save(member);
        if (!saved) throw new RuntimeException("회원 가입중 오류가 발생했습니다.");
    }

    public List<MemberResponse> showall(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(principal instanceof CustomUser)){
            throw new IllegalArgumentException("해당 유저의 정보가 없습니다.");
        }

        Long memberId = ((CustomUser) principal).getMemberId();

        Member member = memberDao.userInfo(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));

        if(!(member.getMemberRole().equals("Y"))){
            throw new IllegalArgumentException("관리자가 아닙니다.");
        }

        return memberDao.showall().stream()
                .map(MemberResponse::of)
                .toList();
    }
}
