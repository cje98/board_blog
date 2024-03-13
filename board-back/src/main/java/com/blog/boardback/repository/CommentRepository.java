package com.blog.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.CommentEntity;
import com.blog.boardback.repository.resultSet.GetCommentListResultSet;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
    
    // AS 별칭을 GetCommentListResultSet 같은 이름으로 해야 값이 넣어짐
    // ex) GetCommentListResultSet에서 getWriteDatetime()이면 AS writeDatetime으로 작성
    @Query(
        value = 
        "SELECT " + 
        "   U.nickname AS nickname, " + 
        "   U.profile_image AS profileImage, " +
        "   C.write_datetime AS writeDatetime, " +
        "   C.content AS content " +
        "FROM comment AS C " +
        "INNER JOIN user AS U " +
        "ON C.user_email = U.email " +
        "WHERE C.board_number = ?1 " +
        "ORDER BY writeDatetime DESC ",
        nativeQuery = true
    )
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

}
