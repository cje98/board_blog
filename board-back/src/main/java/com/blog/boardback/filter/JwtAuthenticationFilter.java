package com.blog.boardback.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.blog.boardback.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    
    // lombok에 있는 필수 생성자 어노테이션 사용하기 위해 final로 생성
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {
            String token = parseBearerToken(request);
            if (token == null){
                filterChain.doFilter(request, response);
                return;
            }

            String email = jwtProvider.validate(token);

            if(email == null){
                filterChain.doFilter(request, response);
                return;
            }
            
            // context에 등록
            AbstractAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // 인증 요청에 대한 세부정보 설정 가능

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);

            // 외부에서 사용할 수 있게 해줌
            SecurityContextHolder.setContext(securityContext);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        // 다음 필터로 넘겨줌
        filterChain.doFilter(request, response);    
    }

    // 뽑아낸 토큰 리턴
    private String parseBearerToken(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");

        // hasText : null, 공백일 경우 false
        boolean hasAuthorization = StringUtils.hasText(authorization);

        if(!hasAuthorization) return null;

        // bearer 인증 방식인지 확인
        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        // 7번 인덱스부터 토큰
        String token = authorization.substring(7);

        return token;
    }

}
