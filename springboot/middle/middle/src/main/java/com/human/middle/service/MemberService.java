package com.human.middle.service;

import com.human.middle.dao.MemberDao;
import com.human.middle.dto.Member;
import com.human.middle.dto.request.LoginReq;
import com.human.middle.dto.request.MemberRegReq;
import com.human.middle.dto.request.UserReq;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
//    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(MemberRegReq req){
        if(memberDao.isDuplicate(req.getUsername())){
            throw new IllegalArgumentException("이미 사용중인 ID 입니다.");
        }
        Member member = req.toEntity();
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
        boolean saved = memberDao.save(member);
        if (!saved) throw new RuntimeException("회원 가입중 오류가 발생했습니다.");
    }

    public Member login(LoginReq req){
        Member member = memberDao.login(req.getUsername());

        if (member == null || !member.getPassword().equals(req.getPassword())){
            throw new IllegalArgumentException("잘못된 아이디 혹은 비밀번호 입니다.");
        }

        return member;
    }

    public List<Member> showall(UserReq req){
        Member member = memberDao.userInfo(req.getUsername());
        System.out.println("DB에서 가져온 권한 값:[" + member.getMemberRole() + "]");
        if(!member.getMemberRole().equals("Y")){
            throw new IllegalArgumentException("관리자가 아닙니다.");
        }

        return memberDao.showall();
    }

    public Member userInfo(UserReq req){
        Member member = memberDao.userInfo(req.getUsername());
        return member;
    }
}
