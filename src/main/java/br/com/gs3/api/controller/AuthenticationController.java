package br.com.gs3.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gs3.api.dto.DadosUsuarioDTO;
import br.com.gs3.api.form.LoginForm;
import br.com.gs3.infra.exception.FalhaAutenticacaoException;
import br.com.gs3.infra.service.TokenService;

@RestController
@RequestMapping
public class AuthenticationController {
	
	@Value("${gs3.mensagens.autenticacao.badCredentialsException}")
	private String mensagemFalhaAutenticacao;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm){
		try {
			Authentication auth =
					this.authenticationManager.authenticate(loginForm.toConverter());
			return ResponseEntity.ok(new DadosUsuarioDTO(this.tokenService.gerarToken(auth), auth.getName(), auth.getAuthorities()));
		}catch (BadCredentialsException e) {
			throw new FalhaAutenticacaoException(this.mensagemFalhaAutenticacao);
		}
	}
}
