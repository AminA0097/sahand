package com.userservice.sahand.Auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private long expiration = 60 * 15 * 4 * 1000; // 4 hours in milliseconds
    private String secret = "Ece72f7qGgGHtL3iDzu4G9dTG8JEehJxq7Vdn7ElDuo";

    public String extractUserName(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    private <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validationToken(String jwt, UserDetails userDetails) {
        final String userName = extractUserName(jwt);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            CustomUserDetail userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(CustomUserDetail userDetails, String uuid) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("uuid", uuid);
        return generateToken(extraClaims, userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            CustomUserDetail userDetails
    ) {
        return buildToken(extraClaims, userDetails, expiration);
    }

    public String extractUUID(String jwt) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(jwt)
                .getBody()
                .get("uuid");
    }
}
