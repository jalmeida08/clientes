package br.com.gs3.api.dto;

public class DadosTokenDTO {
	
	private String accessToken;
	private String tokenType;
	
	
	public DadosTokenDTO(String token) {
		this.tokenType = "bearer";
		this.accessToken = token;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public String getTokenType() {
		return tokenType;
	}

	
}
