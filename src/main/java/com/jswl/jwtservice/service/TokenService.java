package com.jswl.jwtservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jswl.jwtservice.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author zzf
 * @Title: TokenService
 * @ProjectName jwt-service
 * @Description: TODO
 * @date 2018-12-0318:43
 */
@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
