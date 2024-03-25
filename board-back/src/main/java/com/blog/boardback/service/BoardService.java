package com.blog.boardback.service;

import org.springframework.http.ResponseEntity;

import com.blog.boardback.dto.request.board.PatchBoardRequestDto;
import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.request.board.PostCommentRequestDto;
import com.blog.boardback.dto.response.board.GetBoardResponseDto;
import com.blog.boardback.dto.response.board.GetCommentListResponseDto;
import com.blog.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.blog.boardback.dto.response.board.GetLatestBoardListResponseDto;
import com.blog.boardback.dto.response.board.PostBoardResponseDto;
import com.blog.boardback.dto.response.board.PostCommentResponseDto;
import com.blog.boardback.dto.response.board.PutFavoriteResponseDto;
import com.blog.boardback.dto.response.board.PatchBoardResponseDto;
import com.blog.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.blog.boardback.dto.response.board.DeleteBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
}