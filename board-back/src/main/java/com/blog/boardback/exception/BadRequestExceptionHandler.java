package com.blog.boardback.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.boardback.dto.response.ResponseDto;

// @RestControllerAdvice : 전역적으로 예외 처리할 수 있는 어노테이션
@RestControllerAdvice
public class BadRequestExceptionHandler {

    // @ExceptionHandler({예외명.class}) : Controller 클래스에서 에러를 잡아서 메서드로 처리해줌
    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ResponseDto> validationExceptionHandler(Exception exception){
        return ResponseDto.validationFailed();
    }
}
