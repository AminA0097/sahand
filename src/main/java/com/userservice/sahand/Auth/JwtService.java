package com.userservice.sahand.Auth;

import com.userservice.sahand.UserSession.UserSessionSimple;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService {
    private String secret = "Ece72f7qGgGHtL3iDzu4G9dTG8JEehJxq7Vdn7ElDuo";
    private long expiration = 1000 * 60 * 5;
    public String generateToken(UserDetails userDetails,String uuid) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("uuid", uuid);
        return generateToken(extraClaims,userDetails);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ){
        return buildToken(extraClaims,userDetails,expiration);
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String extractUUID(String jwt) {
        return (String) Jwts.parser().setSigningKey(getSignInkey()).parseClaimsJws(jwt).getBody().get("uuid");
    }
    private <T> T extractClaim(String jwt, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllCalims(jwt);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllCalims(String jwt) {
        return
                Jwts.parserBuilder()
                        .setSigningKey(getSignInkey())
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();
    }

    public String extractUserName(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }
    public boolean isTokenExpiredP(String jwt) {
        return isTokenExpired(jwt);
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
}
