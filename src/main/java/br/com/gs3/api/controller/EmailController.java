package br.com.gs3.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gs3.api.form.NovoEmailForm;
import br.com.gs3.api.service.EmailService;

@RestController
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PutMapping("/{idEmail}")
	@Transactional
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> editaEmail(@PathVariable Long idEmail, @RequestBody @Valid NovoEmailForm emailForm) {
			this.emailService.editaEmail(idEmail, emailForm);
			return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idEmail}/{idCliente}")
	@Transactional
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> removeEmail(@PathVariable Long idEmail, @PathVariable Long idCliente){
		this.emailService.removeEmail(idEmail, idCliente);
		return ResponseEntity.ok().build();
	}

}
