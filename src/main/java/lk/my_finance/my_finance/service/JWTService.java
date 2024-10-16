package lk.my_finance.my_finance.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service

public class JWTService {

    @Value("${token.key}")
    private String jwtKey;


    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }


    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        var username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }
    // actual process
    private <T> T extractClaim(String token, Function<Claims,T> claimResolve) {
        final Claims claims = getAllClaims(token);
        return claimResolve.apply(claims);
    }

    private String generateToken(Map<String,Object> extractClaims, UserDetails userDetails){
        extractClaims.put("role",userDetails.getAuthorities());
        Date now = new Date();
        Date expire = new Date(now.getTime() + 1000 * 600);
        Date refreshExpire = new Date(now.getTime() + 1000 * 600 * 600);


        String accessToken = Jwts.builder().setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();


        String refreshToken = Jwts.builder().setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setExpiration(refreshExpire)
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

        return accessToken + " : "+ refreshToken;

    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token)
                .getBody();
    }
    private Key getSignKey(){
        byte[] decode = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(decode);
    }
}
