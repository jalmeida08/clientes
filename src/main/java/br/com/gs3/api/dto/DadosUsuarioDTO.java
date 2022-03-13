package br.com.gs3.api.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class DadosUsuarioDTO {
	
	private String accessToken;
	private String tokenType;
	private String nome;
	private Collection<? extends GrantedAuthority> role;

	public DadosUsuarioDTO(String accessToken, String nome, Collection<? extends GrantedAuthority> collection) {
		this.accessToken = accessToken;
		this.tokenType = "bearer";
		this.nome = nome;
		this.role = collection;
	}

	public String getNome() {
		return nome;
	}


	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public String getTokenType() {
		return tokenType;
	}

	
}
