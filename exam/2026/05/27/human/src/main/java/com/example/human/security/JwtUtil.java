package com.example.human.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;

    private final long accessTokenExpireTime = 1000 * 60 * 60;
    private final long refreshTokenExpireTime = 1000L * 60 * 60 * 24 * 7;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Long memberId, String memberEmail, String memberRole) {
        Date now = new Date();

        return Jwts.builder()
                .subject(String.valueOf(memberId))
                .claim("memberEmail", memberEmail)
                .claim("memberRole", memberRole)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + accessTokenExpireTime))
                .signWith(secretKey)
                .compact();
    }

    public String createRefreshToken() {
        Date now = new Date();

        return Jwts.builder()
                .issuedAt(now)
                .expiration(new Date(now.getTime() + refreshTokenExpireTime))
                .signWith(secretKey)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Long getUserId(String token) {
        return Long.valueOf(getClaims(token).getSubject());
    }

    public String getUserEmail(String token) {
        return getClaims(token).get("memberEmail", String.class);
    }

    public String getUserRole(String token) {
        return getClaims(token).get("memberRole", String.class);
    }

    public boolean validateToken(String token) {
        getClaims(token);
        return true;
    }

    public long getAccessTokenExpiresIn() {
        return accessTokenExpireTime;
    }
}