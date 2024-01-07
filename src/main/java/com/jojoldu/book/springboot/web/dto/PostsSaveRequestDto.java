package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    // Posts Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성하였다.
    // 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안 된다.
    // -> Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이다. 최대한 변경이 없어야한다.
    // Request/Response는 잦은 변경이 일어나므로 Dto를 사용하도록 한다.

}
