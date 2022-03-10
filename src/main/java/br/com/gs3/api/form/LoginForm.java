package br.com.gs3.api.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
	
	private String usuario;
	private String senha;
	
	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken toConverter() {
		return new UsernamePasswordAuthenticationToken(usuario.toLowerCase().trim(), senha);
	}

	@Override
	public String toString() {
		return "LoginForm [usuario=" + usuario + ", senha=" + senha + "]";
	}

	
	
}
