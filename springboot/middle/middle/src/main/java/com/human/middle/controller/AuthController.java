package com.human.middle.controller;

import com.human.middle.dto.request.LoginReq;
import com.human.middle.dto.request.MemberRegReq;
import com.human.middle.dto.response.MemberResponse;
import com.human.middle.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    // 회원가입
    @GetMapping("/register")
    public String resisterForm(Model model){
        // request DTO를 모델에 담아 폼 바이딩
        model.addAttribute("member", new MemberRegReq());
        return "/auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("member") MemberRegReq memberRegReq, BindingResult bindingResult
                                , RedirectAttributes ra){
        // @Vaild 검증 실패 시 폼 페이지로 돌아감
        if(bindingResult.hasErrors()){
            return "auth/register";
        }
        try{
            memberService.register(memberRegReq);
            return "redirect:/auth/login";
        }catch(IllegalArgumentException e){
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/auth/register";
        }
    }

    // 로그인
    @GetMapping("/login")
    public String loginView(Model model){
        model.addAttribute("Login", new LoginReq());
        return "/auth/login";
    }

    //회원 전체 조회
    @GetMapping("/showAll")
    public String showAll(Model model){
        List<MemberResponse> members = memberService.showall();
        model.addAttribute("members", new MemberResponse());
        return "/admin/showAll";
    }
    // 회원 개별 조회
}
