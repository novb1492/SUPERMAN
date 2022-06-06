package com.kimcompany.jangbogbackendver2.Text;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtText {

    public static int accessTokenExpireMin;
    public static int refreshTokenExpireDay;
    public static String accessTokenName;
    public static String refreshTokenName;
    public static String jwtSign;

    @Value("${jwt.access.token.name}")
    public  void setAccessTokenName(String accessTokenName) {
        this.accessTokenName = accessTokenName;
    }

    @Value("${jwt.refresh.token.name}")
    public  void setRefreshTokenName(String refreshTokenName) {
        this.refreshTokenName = refreshTokenName;
    }

    @Value("${jwt.sing}")
    public void setJwtSign(String value) {
        this.jwtSign = value;
    }

    @Value("${refresh.expire.day}")
    public void setRefreshTokenExpireDay(String value) {
        this.refreshTokenExpireDay = Integer.parseInt(value);
    }

    @Value("${access.expire.min}")
    public void setAccessTokenExpireMin(String value) {
        this.accessTokenExpireMin = Integer.parseInt(value);
    }
}
