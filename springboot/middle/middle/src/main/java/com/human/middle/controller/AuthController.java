package com.human.middle.controller;

import com.human.middle.dto.Member;
import com.human.middle.dto.request.LoginReq;
import com.human.middle.dto.request.MemberRegReq;
import com.human.middle.dto.request.UserReq;
import com.human.middle.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody MemberRegReq req){
        memberService.register(req);
        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인
    @GetMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq req){
        Member member = memberService.login(req);
        return ResponseEntity.ok(member);
    }

    //회원 전체 조회
    @GetMapping("/showall")
    public ResponseEntity<?> showall(@Valid @RequestBody UserReq req){
        List<Member> members = memberService.showall(req);
        return ResponseEntity.ok(members);
    }

    // 회원 개별 조회
    @GetMapping("/userInfo")
    public ResponseEntity<?> userInfo(@Valid @RequestBody UserReq req){
        Member member = memberService.userInfo(req);
        return ResponseEntity.ok(member);
    }

}
