package com.assignment.auth;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class AuthTokenHandler {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenHandler.class);

    private String secret = "1234567890";
    private long expirationTimeInSeconds = 300;

    public String generateToken(Authentication authentication) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date expiryDate = Date.from(LocalDateTime.now().plusSeconds(expirationTimeInSeconds)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setSubject(userPrincipal.getUser().getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String retrieveUserFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
