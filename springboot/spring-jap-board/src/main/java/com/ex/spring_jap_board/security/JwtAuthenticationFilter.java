package com.ex.spring_jap_board.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(7);

        try{
            if(!jwtUtil.validateToken(token)){
                filterChain.doFilter(request, response);
                return;
            }

            Long memberId = jwtUtil.getMemberId(token);
            String memberEmail  = jwtUtil.getMemberEmail(token);
            String memberRole = jwtUtil.getMemberRole(token);

            CustomUserDetail customUserDetail = new CustomUserDetail(memberId, memberEmail, null, memberRole);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(customUserDetail, null, customUserDetail.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch(Exception e){
            SecurityContextHolder.clearContext();

            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
