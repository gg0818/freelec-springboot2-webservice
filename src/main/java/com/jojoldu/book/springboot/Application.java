package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing // JPA auditing 활성화
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다. 항상 프로젝트 최상단에 위치!
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 WAS(Web Application Server)를 실행한다. 내장 톰캣!
    }
}
