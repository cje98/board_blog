package com.blog.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.BoardEntity;

// JpaRepository<사용할 엔티티, 엔티티 pk 타입> 
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
    
}
