package br.com.gs3.api.form;

import br.com.gs3.infra.model.Contato;
import br.com.gs3.infra.model.Email;

public class NovoEmailForm {
	
	private String email;
	
	public Email toEmail(Contato c) {
		Email e = new Email();
		e.setEmail(email);
		e.setContato(c);
		return e;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NovoEmailForm [email=" + email + "]";
	}

	
	

}
