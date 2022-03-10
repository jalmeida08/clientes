package br.com.gs3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cliente")
public class ClienteController {

	@GetMapping
	public ResponseEntity<?> teste() {
		return ResponseEntity.ok("Sucesso");
	}
}
