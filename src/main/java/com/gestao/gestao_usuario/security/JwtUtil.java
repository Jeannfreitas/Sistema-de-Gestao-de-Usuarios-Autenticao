package com.gestao.gestao_usuario.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "minha-chave-secreta-super-forte-minimo-32-bytes";
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hora

    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY)
                .compact();
    }
}