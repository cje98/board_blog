package com.blog.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.FavoriteEntity;
import com.blog.boardback.entity.primaryKey.FavoritePk;

// 모든 컬럼이 복합키인 경우 pk를 따로 만들어줘야함.
@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk>{
    
}
