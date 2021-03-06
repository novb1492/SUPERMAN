package com.kimcompany.jangbogbackendver2.Jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.kimcompany.jangbogbackendver2.Text.JwtText;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class JwtService {

    public String getAccessToken(long id) {
        return JWT.create().withSubject(JwtText.accessTokenName).withClaim("id",id).withExpiresAt(new Date(System.currentTimeMillis()+1000* JwtText.accessTokenExpireMin)).sign(Algorithm.HMAC512(JwtText.jwtSign));
    }
    public String getToken(String tokenName,int expireSecond,String jwtSign) {
        return JWT.create().withSubject(tokenName).withExpiresAt(new Date(System.currentTimeMillis()+1000*expireSecond)).sign(Algorithm.HMAC512(jwtSign));
    }
    public long openAccessToken(String accessToken) {
        return JWT.require(Algorithm.HMAC512(JwtText.jwtSign)).build().verify(accessToken).getClaim("id").asLong();
    }
    public void openEmptyJwt(String token,String sign){
        JWT.require(Algorithm.HMAC512(sign)).build().verify(token);
    }
    public int getAccessTokenSecond(){
        return 1000 * JwtText.accessTokenExpireMin;
    }
    public int getRefreshTokenDay(){
        return JwtText.refreshTokenExpireDay;
    }

}
