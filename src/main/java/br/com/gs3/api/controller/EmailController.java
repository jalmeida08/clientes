package br.com.gs3.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> editaEmail(@PathVariable Long idEmail, @RequestBody NovoEmailForm emailForm) {
			this.emailService.editaEmail(idEmail, emailForm);
			return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idEmail}")
	@Transactional
	public ResponseEntity<?> removeEmail(@PathVariable Long idEmail){
		this.emailService.removeEmail(idEmail);
		return ResponseEntity.ok().build();
	}

}
