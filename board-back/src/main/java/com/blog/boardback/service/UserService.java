package com.blog.boardback.service;

import org.springframework.http.ResponseEntity;

import com.blog.boardback.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}
