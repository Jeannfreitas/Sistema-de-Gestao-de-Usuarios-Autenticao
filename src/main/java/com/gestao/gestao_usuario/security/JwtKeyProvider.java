package com.gestao.gestao_usuario.security;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtKeyProvider {

    private static final String SECRET = "minha-chave-secreta-super-forte-minimo-32-bytes";

    public static SecretKey getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
}