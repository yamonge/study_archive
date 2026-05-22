package com.ex.spring_jap_board.security;

import com.ex.spring_jap_board.entity.Member;
import com.ex.spring_jap_board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
         Member member = memberRepository.findByMemberEmail(memberEmail)
                .orElseThrow(() -> new UsernameNotFoundException("사용자 없음"));
         CustomUserDetail customUserDetail = new CustomUserDetail(
         member.getMemberId() ,member.getMemberEmail(), member.getMemberPwd(), member.getMemberRole());
        return customUserDetail;
    }
}
