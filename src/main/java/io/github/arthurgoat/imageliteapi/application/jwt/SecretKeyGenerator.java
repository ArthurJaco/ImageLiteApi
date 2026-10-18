package io.github.arthurgoat.imageliteapi.application.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class SecretKeyGenerator {

    @Value("${security.jwt.secret:}")
    private String configuredSecret;

    private SecretKey key;

    public SecretKey getKey(){
        if (key == null){
            if (configuredSecret == null || configuredSecret.isBlank()) {
                key = Jwts.SIG.HS256.key().build();
            } else {
                byte[] secretBytes = configuredSecret.getBytes(StandardCharsets.UTF_8);
                if (secretBytes.length < 32) {
                    throw new IllegalStateException("JWT_SECRET must contain at least 32 characters.");
                }
                key = Keys.hmacShaKeyFor(secretBytes);
            }
        }
        return key;
    }
}
