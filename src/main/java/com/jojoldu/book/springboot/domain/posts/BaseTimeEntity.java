package com.jojoldu.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // ① JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createDate, modifiedDate)를 자동으로 관리하는 역할
@EntityListeners(AuditingEntityListener.class) // ② BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {

    @CreatedDate // ③ Entity가 생성도어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createDate;

    @LastModifiedDate // ④ 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
