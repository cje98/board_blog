package com.blog.boardback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="search_log")
@Table(name="search_log")
public class SearchLogEntity {
    // 클래스명을 테이블 이름으로 사용하면 자동으로 찾아가지만 이름을 다르게 하는 경우 name 속성 사용해야함.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;
    private String relationWord;
    private boolean relation;
    
    public SearchLogEntity(String searchWord, String relationWord, boolean relation){
        this.searchWord = searchWord;
        this.relationWord = relationWord;
        this.relation = relation;
    }
}
