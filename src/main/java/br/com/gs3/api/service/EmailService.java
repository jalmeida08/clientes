package br.com.gs3.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.form.NovoEmailForm;
import br.com.gs3.dominio.bo.EmailBO;
import br.com.gs3.infra.exception.DadosNaoEncontradoException;
import br.com.gs3.infra.exception.NegocioException;
import br.com.gs3.infra.exception.ParametroNaoInformadoException;
import br.com.gs3.infra.exception.RegraNegocialException;
import br.com.gs3.infra.model.Email;
import br.com.gs3.infra.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	private Email getEmail(Long idCliente) {
		if(idCliente == null)
			throw new ParametroNaoInformadoException("É obrigatório que informe o parametro do e-mail");
		
		return this.emailRepository
				.findById(idCliente)
				.orElseThrow(() -> new DadosNaoEncontradoException());
	}
	
	private List<Email> listaEmailCliente(Long idCliente) {
		return this.emailRepository.listaEmailCliente(idCliente);
	}

	public void editaEmail(Long idEmail, NovoEmailForm emailForm) {
		Email e = getEmail(idEmail);
		e.setEmail(emailForm.getEmail());
		
	}

	public void removeEmail(Long idEmail, Long idCliente) {
		EmailBO bo = new EmailBO();
		try {
			bo.isPermitidoRemoverEmailCliente(listaEmailCliente(idCliente));
			Email e = getEmail(idEmail);
			this.emailRepository.delete(e);		
		} catch (NegocioException e) {
			throw new RegraNegocialException(e.getMessage());
		}
	}
	

}
