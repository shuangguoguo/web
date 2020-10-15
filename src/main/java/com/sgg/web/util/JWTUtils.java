package com.sgg.web.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTUtils {


    private static final long EXPIRE_DATE = 30*60*1000;

    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";

    public static String createToken(String username,String password){
        String token;
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            token = "";
            log.error("Function [createToken] error",e);
        }
        return token;
    }

    public static Map<String, Claim> verifyToken(String token){
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
    }
}
