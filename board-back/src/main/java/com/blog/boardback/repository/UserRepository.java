package com.blog.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.boardback.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
    // existsBy : JPA에서 제공하는 메소드 중 하나, 특정 조건을 만족하는 엔티티가 존재하는지 여부 리턴
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);
    
}
