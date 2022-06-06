package com.kimcompany.jangbogbackendver2.Config;


import com.kimcompany.jangbogbackendver2.Filter.CorsConfig;
import com.kimcompany.jangbogbackendver2.Filter.LoginFilter;
import com.kimcompany.jangbogbackendver2.Util.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration//빈등록: 스프링 컨테이너에서 객체에서 관리
@EnableWebSecurity/////필터를 추가해준다
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsConfig corsConfig;
    private final LoginService loginService;
  
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
        return  new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .addFilter(corsConfig.corsfilter())
                .addFilter(new LoginFilter(authenticationManager(),loginService))
               // .addFilter(new authorizationFilter(authenticationManager(),jwtService,redisTemplate,access_token_cookie_name,refresh_token_cookie_name))
                .formLogin().disable().httpBasic().disable()
                .authorizeRequests().antMatchers("/auth/**").authenticated()
                .anyRequest().permitAll();

    }
}
