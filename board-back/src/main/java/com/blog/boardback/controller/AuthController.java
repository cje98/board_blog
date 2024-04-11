package com.blog.boardback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.boardback.dto.request.auth.SignInRequestDto;
import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.auth.SignInResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;
import com.blog.boardback.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    // @RequiredArgsConstructor : 클래스 내의 final로 선언된 필드를 사용하여 생성자 자동 생성 + final 필드 의존성 주입 처리
    private final AuthService authService;
    
    // @Valid : SignUpResponseDto 객체 유효성 검사 확인
    // <? super 타입> : 타입 또는 그 타입의 상위 클래스를 응답으로 사용할 수 있음
    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;

        // 매핑 확인 방법(Postman)
        // MyWorkspace 가서 매핑 종류 선택(GET/POST 등)
        // url 입력, Body > raw > json 선택 후 값 입력
        // Send
        
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }

}
