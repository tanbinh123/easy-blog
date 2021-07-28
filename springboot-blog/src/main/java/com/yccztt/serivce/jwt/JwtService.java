package com.yccztt.serivce.jwt;

import com.yccztt.domain.jwt.JWTEntity;

/**
 * @Author hyz
 * @Date 2021/7/28
 */
public interface JwtService {

    void saveJwt(JWTEntity entity);

    JWTEntity queryJwt(String userId);

    void deleteJwt(String userId);
}
