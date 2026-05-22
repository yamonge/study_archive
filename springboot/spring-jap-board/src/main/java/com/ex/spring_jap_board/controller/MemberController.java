package com.ex.spring_jap_board.controller;

import com.ex.spring_jap_board.dto.request.LoginReq;
import com.ex.spring_jap_board.dto.request.ReissueReq;
import com.ex.spring_jap_board.dto.request.SignupReq;
import com.ex.spring_jap_board.dto.response.LoginRes;
import com.ex.spring_jap_board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupReq requestDto) {
        memberService.signup(requestDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRes> login(@RequestBody LoginReq requestDto) {
        LoginRes responseDto = memberService.login(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/user/test")
    public ResponseEntity<String> userTest() {
        return ResponseEntity.ok("USER 접근 성공");
    }

    @GetMapping("/admin/test")
    public ResponseEntity<String> adminTest() {
        return ResponseEntity.ok("ADMIN 접근 성공");
    }

    @PostMapping("/reissue")
    public ResponseEntity<LoginRes> reissue(@RequestBody ReissueReq requestDto) {
        LoginRes responseDto = memberService.reissue(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
