package com.ex.spring_jap_board.service;

import com.ex.spring_jap_board.dto.request.LoginReq;
import com.ex.spring_jap_board.dto.request.ReissueReq;
import com.ex.spring_jap_board.dto.request.SignupReq;
import com.ex.spring_jap_board.dto.response.LoginRes;
import com.ex.spring_jap_board.entity.Member;
import com.ex.spring_jap_board.repository.MemberRepository;
import com.ex.spring_jap_board.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void signup(SignupReq requestDto){
        if (memberRepository.existsByMemberEmail(requestDto.getMemberEmail())) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        Member member = new Member();
        member.setMemberEmail(requestDto.getMemberEmail());
        member.setMemberPwd(passwordEncoder.encode(requestDto.getMemberPwd()));
        member.setMemberName(requestDto.getMemberName());
        member.setMemberRole("ROLE_USER");

        memberRepository.save(member);
    }

    public LoginRes login(LoginReq requestDto){
        Member member = memberRepository.findByMemberEmail(requestDto.getMemberEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        if (!passwordEncoder.matches(requestDto.getMemberPwd(), member.getMemberPwd())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = jwtUtil.createToken(
                member.getMemberId(),
                member.getMemberEmail(),
                member.getMemberRole()
        );

        String refreshToken = jwtUtil.createRefreshToken();

        member.setRefreshToken(refreshToken);
        memberRepository.save(member);

        return new LoginRes(
                "Bearer",
                accessToken,
                refreshToken,
                jwtUtil.getAccessTokenExpiresIn()
        );
    }

    public LoginRes reissue(ReissueReq requestDto) {

        String refreshToken = requestDto.getRefreshToken();

        if (!jwtUtil.validateToken(refreshToken)) {
            throw new RuntimeException("RefreshToken이 유효하지 않습니다.");
        }

        Member member = memberRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("저장된 RefreshToken이 없습니다."));

        String newAccessToken = jwtUtil.createToken(
                member.getMemberId(),
                member.getMemberEmail(),
                member.getMemberRole()
        );

        return new LoginRes(
                "Bearer",
                newAccessToken,
                refreshToken,
                jwtUtil.getAccessTokenExpiresIn()
        );
    }
}
