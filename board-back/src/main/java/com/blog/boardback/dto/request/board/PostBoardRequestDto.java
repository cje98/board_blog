package com.blog.boardback.dto.request.board;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    // @NotNull 사용 이유 : 빈 배열이 올 수 있지만, 해당 필드는 필수여야 함.
    @NotNull
    private List<String> boardImageList;

}
