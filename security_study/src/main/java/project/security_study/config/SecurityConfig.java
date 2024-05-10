package project.security_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf((auth)-> auth.disable()); //csrf 공격을 방어한다
        http.authorizeRequests((auth) -> auth

                        // /** -> 모든 경로
                        .requestMatchers("/user/**").authenticated() // /user/**로 들어온 사람들은 인증이 필요하다
                        .requestMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                        // /manager/**로 들어온 사람들은 권한이 필요함
                        .requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll()
                );

        //로그인 페이지 설정
        http.formLogin((auth)-> auth.loginPage("/login")); //이거 get요청임 ㅋㅋ

        return http.build();
    }
}
