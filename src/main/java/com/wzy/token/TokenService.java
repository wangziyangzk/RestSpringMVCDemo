package com.wzy.token;

/*
**  用户身份鉴权
 */
public interface TokenService {

    String createToken(String token);

    boolean checkToken(String token);

    void deleteToken(String token);

}
