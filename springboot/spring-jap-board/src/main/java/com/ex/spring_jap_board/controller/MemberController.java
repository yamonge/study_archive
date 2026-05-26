package com.ex.spring_jap_board.controller;

import com.ex.spring_jap_board.dto.request.LoginReq;
import com.ex.spring_jap_board.dto.request.ReissueReq;
import com.ex.spring_jap_board.dto.request.SignupReq;
import com.ex.spring_jap_board.dto.response.ApiResponse;
import com.ex.spring_jap_board.dto.response.LoginRes;
import com.ex.spring_jap_board.security.CustomUserDetail;
import com.ex.spring_jap_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Void>> signup(@RequestBody SignupReq requestDto) {
        memberService.signup(requestDto);
        return ResponseEntity.ok(ApiResponse.ok("회원가입 성공", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginRes>> login(@RequestBody LoginReq requestDto) {
        LoginRes responseDto = memberService.login(requestDto);
        return ResponseEntity.ok(ApiResponse.ok("로그인 성공!", responseDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(
            @AuthenticationPrincipal CustomUserDetail userDetail
    ){
        memberService.logout(userDetail.getMemberId());

        return ResponseEntity.ok(ApiResponse.ok("로그아웃 성공!", null));
    }

    @GetMapping("/user/test")
    public ResponseEntity<ApiResponse<Void>> userTest() {
        return ResponseEntity.ok(ApiResponse.ok("USER 접근 성공", null));
    }

    @GetMapping("/admin/test")
    public ResponseEntity<ApiResponse<Void>> adminTest() {
        return ResponseEntity.ok(ApiResponse.ok("ADMIN 접근 성공", null));
    }

    @PostMapping("/reissue")
    public ResponseEntity<ApiResponse<LoginRes>> reissue(@RequestBody ReissueReq requestDto) {
        LoginRes responseDto = memberService.reissue(requestDto);
        return ResponseEntity.ok(ApiResponse.ok("토큰 재 생성 성공!", responseDto));
    }
}
