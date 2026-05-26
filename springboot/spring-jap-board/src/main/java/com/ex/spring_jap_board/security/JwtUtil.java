package com.ex.spring_jap_board.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String createToken(Long memberId, String memberEmail, String memberRole){
        return Jwts.builder()
                .claim("memberId", memberId)
                .claim("memberEmail", memberEmail)
                .claim("memberRole", memberRole)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
                        )
                )
                .compact();
    }

    public String createRefreshToken() {
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
                        )
                )
                .compact();
    }

    public Long getAccessTokenExpiresIn() {
        return System.currentTimeMillis() + 1000L * 60 * 60;
    }
    public Long getMemberId(String token){
        return  parseClaims(token)
                .get("memberId", Long.class);
    }

    public String getMemberEmail(String token){
        return  parseClaims(token)
                .get("memberEmail", String.class);
    }

    public String getMemberRole(String token){
        return parseClaims(token)
                .get("memberRole", String.class);
    }

    public Claims parseClaims(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
