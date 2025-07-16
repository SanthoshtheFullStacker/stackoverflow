package com.example.backend.auth.Serviceimpl;

import com.example.backend.auth.Models.Usermodel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTserviceimpl {

    private final String SECRET_KEY = "6128ea357c1b64ce81804095bd347fb03886bac354249d8da7421a519d6362b6760bb95970f9fa9d0ae8a1356e283529b4f97067a2f5fe1cf7f2751d";


    Map<String,Object> claims = new HashMap<>();

    public String generateToken(Usermodel usermodel){

        claims.put("username",usermodel.getUsername());
        claims.put("email",usermodel.getEmail());
        claims.put("displayname",usermodel.getDisplayname());
        claims.put("profilenameimageurl",usermodel.getProfileimageurl());
        claims.put("bio",usermodel.getBio());

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(usermodel.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 100))
                .and().signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();

    }

    public Claims extractallclaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    public String extractUsername(String token) {
        return extractallclaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        return extractallclaims(token).getExpiration().before(new Date());
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !(isTokenExpired(token));
    }


}
