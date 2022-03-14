package br.com.gs3.infra.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gs3.infra.service.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private UserDetailsService userDetailsService;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UserDetailsService userDetailsService) {
		this.tokenService = tokenService;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String token = this.reuperaToken(request);
		final boolean isValido = this.tokenService.isTokenValid(token);
		
		if(isValido)
			this.autenticaCliente(token);
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticaCliente(String token) {
		final String usuario = this.tokenService.getUserName(token);
		final UserDetails u = this.userDetailsService.loadUserByUsername(usuario);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(u, null, u.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String reuperaToken(HttpServletRequest request) {
		final String token = request.getHeader("Authorization");
		if(token == null || token.length() == 0 || !token.toLowerCase().startsWith("bearer "))
			return null;
		return token.substring(7, token.length());
	}

}
