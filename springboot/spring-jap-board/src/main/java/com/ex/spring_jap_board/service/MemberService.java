package com.ex.spring_jap_board.service;

import com.ex.spring_jap_board.dto.request.LoginReq;
import com.ex.spring_jap_board.dto.request.ReissueReq;
import com.ex.spring_jap_board.dto.request.SignupReq;
import com.ex.spring_jap_board.dto.response.LoginRes;
import com.ex.spring_jap_board.dto.response.MemberRes;
import com.ex.spring_jap_board.entity.Member;
import com.ex.spring_jap_board.exception.CustomException;
import com.ex.spring_jap_board.repository.MemberRepository;
import com.ex.spring_jap_board.security.CustomUserDetail;
import com.ex.spring_jap_board.security.JwtUtil;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public void signup(SignupReq requestDto){
        if (memberRepository.existsByMemberEmail(requestDto.getMemberEmail())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "이미 가입된 이메일입니다.");
        }

        Member member = new Member();
        member.setMemberEmail(requestDto.getMemberEmail());
        member.setMemberPwd(passwordEncoder.encode(requestDto.getMemberPwd()));
        member.setMemberName(requestDto.getMemberName());
        member.setMemberRole("USER");

        memberRepository.save(member);
    }

    public LoginRes login(LoginReq requestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getMemberEmail(),
                        requestDto.getMemberPwd()
                )
        );

        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();

        Member member = memberRepository.findById(userDetail.getMemberId())
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "회원이 없습니다."));

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

    public void logout(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "회원이 없습니다."));

        member.setRefreshToken(null);
        memberRepository.save(member);
    }

    public LoginRes reissue(ReissueReq requestDto) {

        String refreshToken = requestDto.getRefreshToken();

        if (!jwtUtil.validateToken(refreshToken)) {
            throw new CustomException(HttpStatus.UNAUTHORIZED, "RefreshToken이 유효하지 않습니다.");
        }

        Member member = memberRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new CustomException(HttpStatus.UNAUTHORIZED, "저장된 RefreshToken이 없습니다."));

        String newAccessToken = jwtUtil.createToken(
                member.getMemberId(),
                member.getMemberEmail(),
                member.getMemberRole()
        );

        String newRefreshToken = jwtUtil.createRefreshToken();

        member.setRefreshToken(newRefreshToken);
        memberRepository.save(member);

        return new LoginRes(
                "Bearer",
                newAccessToken,
                newRefreshToken,
                jwtUtil.getAccessTokenExpiresIn()
        );
    }

    // 전체 조회 : Entity -> Res 변환 스트림 사용
    public List<MemberRes> findAll(){
        return memberRepository.findAll()
                .stream()
                .map(MemberRes::of)
                .toList();
    }

    public MemberRes findById(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다.id = " + id));
        return MemberRes.of(member);
    }
}
