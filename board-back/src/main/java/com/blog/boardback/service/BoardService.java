package com.blog.boardback.service;

import org.springframework.http.ResponseEntity;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.response.board.PostBoardResponseDto;

public interface BoardService {
    
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);

}
