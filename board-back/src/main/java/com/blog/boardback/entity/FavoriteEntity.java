package com.blog.boardback.entity;

import com.blog.boardback.entity.primaryKey.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class) // Id로 사용할 클래스 따로 연결
public class FavoriteEntity {
    
    // 복합키라 둘 다 @Id 적용
    @Id
    private String userEmail;

    @Id
    private int boardNumber;

}
