package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody를 메소드마다 작성하지 않고 컨트롤러 상단에 선언 / 컨트롤러를 JSON을 반환하는 컨트롤러로 만든다.
public class HelloController {

    @GetMapping("/hello") // HTTP Method Get의 요청을 받을 수 있는 API
    public String Hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
