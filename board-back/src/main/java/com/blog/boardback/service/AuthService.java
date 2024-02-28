package com.blog.boardback.service;

import org.springframework.http.ResponseEntity;

import com.blog.boardback.dto.request.auth.SignInRequestDto;
import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.auth.SignInResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    // ? super T : 와일드 카드 제네릭 타입, "T"타입 또는 "T"의 부모 타입까지 받을 수 있다.
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
