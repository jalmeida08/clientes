package br.com.gs3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.form.NovoEmailForm;
import br.com.gs3.infra.exception.DadosNaoEncontradoException;
import br.com.gs3.infra.exception.ParametroNaoInformadoException;
import br.com.gs3.infra.model.Email;
import br.com.gs3.infra.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	private Email getEmail(Long idEmail) {
		if(idEmail == null)
			throw new ParametroNaoInformadoException("É obrigatóri que informe o parametro do e-mail");
		
		return this.emailRepository
				.findById(idEmail)
				.orElseThrow(() -> new DadosNaoEncontradoException());
	}

	public void editaEmail(Long idEmail, NovoEmailForm emailForm) {
		Email e = getEmail(idEmail);
		e.setEmail(emailForm.getEmail());
		
	}

	public void removeEmail(Long idEmail) {
		Email e = getEmail(idEmail);
		this.emailRepository.delete(e);		
	}
	

}
