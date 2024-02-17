package com.blog.boardback.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
    
    // @Value : application.properties에 있는 값 가져올 수 있음
    @Value("${secret-key}")
    private String secretKey;

    public String create(String email){

        // 현재시간에서 1시간 추가한 날짜
        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        
        // ES256, HS256 상관없음
        String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.ES256, secretKey)
                    .setSubject(email).setIssuedAt(new Date())
                    .setExpiration(expiredDate)
                    .compact();

        return jwt;
    }

    public String validate(String jwt){

        Claims claims = null;

        try {
            claims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return claims.getSubject();
    }

}
