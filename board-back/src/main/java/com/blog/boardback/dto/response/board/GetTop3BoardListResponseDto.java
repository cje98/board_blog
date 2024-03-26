package com.blog.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.blog.boardback.common.ResponseCode;
import com.blog.boardback.common.ResponseMessage;
import com.blog.boardback.dto.object.BoardListItem;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetTop3BoardListResponseDto extends ResponseDto{

    private List<BoardListItem> top3List;

    private GetTop3BoardListResponseDto(List<BoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.top3List = BoardListItem.getList(boardListViewEntities);
    }

    public static ResponseEntity<GetTop3BoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities){
        GetTop3BoardListResponseDto result = new GetTop3BoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
