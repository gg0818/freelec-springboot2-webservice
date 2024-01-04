package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 어노테이션 순서를 주요 어노테이션을 클래스에 가깝게 둔다.
@Getter // ⑥ Lombok의 어노테이션 - 필수X
@NoArgsConstructor // ⑤ Lombok의 어노테이션 - 필수X
@Entity // ① JPA의 어노테이션 - 필수
public class Posts {
    // Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이다.
    // Entity 클래스라고 한다.
    // DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업한다.
    @Id // ②
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ③
    private Long id;

    @Column(length = 500, nullable = false) // ④
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // ⑦
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
