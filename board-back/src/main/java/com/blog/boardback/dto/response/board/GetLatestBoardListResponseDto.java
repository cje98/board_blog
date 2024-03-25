package com.blog.boardback.dto.response.board;

import com.blog.boardback.common.ResponseCode;
import com.blog.boardback.common.ResponseMessage;
import com.blog.boardback.dto.object.BoardListItem;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.entity.BoardListViewEntity;

import lombok.Getter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetLatestBoardListResponseDto extends ResponseDto{

    private List<BoardListItem> latestList;

    private GetLatestBoardListResponseDto(List<BoardListViewEntity> boardEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.latestList = BoardListItem.getList(boardEntities);
    }

    public static ResponseEntity<GetLatestBoardListResponseDto> success(List<BoardListViewEntity> boardEntities) {
        GetLatestBoardListResponseDto result = new GetLatestBoardListResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
}
