package br.com.gs3.infra.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${dados.jwt.expiration}")
	private String expiration;
	
	@Value("${dados.jwt.secret}")
	private String secret;


	
	public String gerarToken(Authentication authenticate) {
		UserDetails usuario = (UserDetails) authenticate.getPrincipal();
		Date now = new Date();
		Date dataExpiracao = new Date(now.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
				.setIssuer("API DESAFIO GS3")
				.setSubject(usuario.getUsername())
				.setIssuedAt(now)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;			
		}
	}

	public String getUserName(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return claims.getSubject().toString();
	}

	
}