package com.blog.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.boardback.dto.response.user.GetSignInUserResponseDto;
import com.blog.boardback.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    // @AuthenticationPrincipal : 현재 사용자의 인증(principal) 정보를 가진 객체로, 원하는 데이터 추출 시 사용함
    // 확인 방법
    // 1) Postman에서 사용자 로그인 후 받은 토큰 복사
    // 2) Auth 탭 > Type(Bearer Token) 바꾸고 Token 빈칸에 값 넣은 후 Send
    @GetMapping("/")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
        return response;
    }
    
}
