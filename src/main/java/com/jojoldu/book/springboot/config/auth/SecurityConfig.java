package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //① Spring Security 설정들을 활성화시켜 준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //② h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.

                .and()
                .authorizeRequests() //③ 요청승인, URL별 권한 관리를 설정하는 옵션의 시작점이다.
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //permitAll() : 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //④antMatchers : 권한 관리 대상을 지정하는 옵션이다. /api/v1/** 주소를 가진 api는 USER 권한을 가진 사람만 가능하다.
                .anyRequest().authenticated() //⑤anyRequest :설정된 값들 이외 나머지 URL들을 나타낸다.
                                            // authenticated():나머지 URL들은 모두 인증된 사용자들에게만 허용하게 한다.
                                            // 인증된 사용자 즉, 로그인한 사용자들을 이야기한다.

                .and()
                .logout()
                .logoutSuccessUrl("/") //⑥ 로그아웃 기능에 대한 여러 설정의 진입점. 로그아웃 성공 시 / 주소로 이동

                .and()
                .oauth2Login()//⑦ OAuth2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()//⑧ OAuth2 로그인 성공 후 사용자 정보를 가져올 때의 설정
                .userService(customOAuth2UserService); //⑨ 소셜 로그인 성공 후 후속 조치를 진행할 UserService 인터페이스의 구현체 등록

    }
}
