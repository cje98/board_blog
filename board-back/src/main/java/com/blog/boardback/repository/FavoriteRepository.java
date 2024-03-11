package com.blog.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.FavoriteEntity;
import com.blog.boardback.entity.primaryKey.FavoritePk;
import com.blog.boardback.repository.resultSet.GetFavoriteListResultSet;

// 모든 컬럼이 복합키인 경우 pk를 따로 만들어줘야함.
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk>{
    
    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);

    @Query(
        value=
        "SELECT " +
        "U.email AS email, " +
        "U.nickname AS nickname, " +
        "U.profile_image AS profileImage " +
        "FROM favorite AS F " +
        "INNER JOIN user AS U " +
        "ON F.user_email = U.email " +
        "WHERE F.board_number = ?1 ",
        nativeQuery = true
    )
    List<GetFavoriteListResultSet> getFavoriteList(Integer boardNumber);


}
