package com.blog.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.BoardEntity;
import com.blog.boardback.repository.resultSet.GetBoardResultSet;

// JpaRepository<사용할 엔티티, 엔티티 pk 타입> 
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
    BoardEntity findByBoardNumber(Integer boardNumber);

    // Native Query : 쿼리 직접 작성, ; 없애야 함
    // nativeQuery = true : 쿼리 지정 true
    // ?1 : 첫 번째 매개변수로 지정
    // resultSet에 작성한 메소드로 호출가능
    @Query(
        value = 
        "SELECT " + 
        "B.board_number AS boardNumber, " +
        "B.title AS title, " +
        "B.content AS content, " +
        "B.write_datetime AS writeDatetime, " +
        "B.writer_email AS writerEmail, " +
        "U.nickname AS writerNickname, " +
        "U.profile_image AS writeProfileImage " +
        "FROM board AS B " +
        "INNER JOIN user AS U " +
        "ON B.writer_email = U.email " +
        "WHERE board_number = ?1",
        nativeQuery = true
    
    )
    GetBoardResultSet getBoard(Integer boardNumber);
}
