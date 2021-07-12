package com.yccztt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author hyz
 * @create 2021-06-15 下午3:03
 */
public class JwtUtil {

    private static final String EXPIRED = "token已过期";
    private static final String SIGNATURE_VERIFICATION = "token签名失败";
    private static final String DECODE_ERROR = "token解析失败,请重新登陆获取token";
    private static final String NOT_LOGIN = "未登录";

    private static long expire = 7200000;       //过期时间:2小时
    private static String secret = "6Dx8SIuaHXJYnpsG18SSpjPs50lZcT52";   //密钥

    /**
     * 校验token是否正确
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean verify(String token) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier build = JWT.require(algorithm).build();
            DecodedJWT jwt = build.verify(token);
            System.out.println("token=====>"+jwt);
            return true;
        } catch (TokenExpiredException tokenExpiredException) {
            throw new Exception(EXPIRED);
        } catch (SignatureVerificationException signatureVerificationException) {
            throw new Exception(SIGNATURE_VERIFICATION);
        } catch (JWTDecodeException jwtDecodeException) {
            throw new Exception(DECODE_ERROR);
        } catch (Exception exception) {
            throw new Exception(NOT_LOGIN);
        }
    }

    /**
     * 生成签名,2小时后过期,返回加密后的token
     * @param username
     * @return
     */
    public static String sign(String username) {
        Date date = new Date(System.currentTimeMillis() + expire);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //附带user信息
        return JWT.create()
                .withClaim("username",username)
                .withExpiresAt(date)
                .sign(algorithm);
    }
}
