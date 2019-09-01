package com.wzy.token;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
**  管理token的实现类
 */
@Component
public class TokenManager implements TokenService {

    private static Map<String,String> tokenMap = new HashMap<String, String>();

    /*
    **  使用UUID创建唯一的token标识
     */
    public String createToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenMap.put(token,username);
        return token;
    }

    public boolean checkToken(String token) {
        return !token.isEmpty() &&tokenMap.containsKey(token);
    }

    public void deleteToken(String token) {
        tokenMap.remove(token);
    }
}
