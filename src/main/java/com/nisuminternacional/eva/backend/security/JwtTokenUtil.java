package com.nisuminternacional.eva.backend.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {

    private static JwtTokenUtil instance;
    private String secret = "secretKey";

    private JwtTokenUtil() {}

    public static JwtTokenUtil getInstance() {
        if (instance == null) {
            synchronized (JwtTokenUtil.class) {
                if (instance == null) {
                    instance = new JwtTokenUtil();
                }
            }
        }
        return instance;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token, String subject) {
        return subject.equals(getSubjectFromToken(token)) && !isTokenExpired(token);
    }

    public String getSubjectFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}

