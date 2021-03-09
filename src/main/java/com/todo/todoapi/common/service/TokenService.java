package com.todo.todoapi.common.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class TokenService {

	public String generateTokenFromUserEmail(String userEmail) {
		return Jwts.builder().setSubject(userEmail).setExpiration(new Date(System.currentTimeMillis() + 7200000))
				.signWith(SignatureAlgorithm.HS512, "tempTokenKey").compact();
	}

	public String validateTokenAndGetData(String tokenId) throws ExpiredJwtException, UnsupportedJwtException,
			MalformedJwtException, SignatureException, IllegalArgumentException {
		String tokenData = Jwts.parser().setSigningKey("tempTokenKey").parseClaimsJws(tokenId).getBody().getSubject();
		return tokenData;
	}
}
