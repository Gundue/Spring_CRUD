package com.example.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//접근 권한 설정 속성 protected와 동일
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//모든 필드에 getter 자동생성 해주기 위함
@Getter
// 객체를 테이블과 매핑할 엔티티라고 jpa에게 알려주는
@Entity
//엔티티와 매핑되는 테이블 정보
@Table(name = "board")
public class BoardEntity extends TimeEntity{
    //테이블 기본 키
    @Id
    //기본키 대체키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String writer;

    @Column(length = 100)
    private String title;

    @Column(columnDefinition = "Text")
    private String content;

    //Build패턴 클래스 생성 Setter 대신 사용용
    @Builder
    public BoardEntity(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
