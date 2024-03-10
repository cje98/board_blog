package com.blog.boardback.repository.resultSet;

public interface GetBoardResultSet {
    // 메소드로 작성
    Integer getBoardNumber();
    String getTitle();
    String getContent();  
    String getWriteDatetime();
    String getWriterEmail();
    String getWriterNickname();
    String getWriterProfileImage(); 
}
