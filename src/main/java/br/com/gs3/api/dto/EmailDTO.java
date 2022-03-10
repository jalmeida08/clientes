package br.com.gs3.api.dto;

import br.com.gs3.infra.model.Email;

public class EmailDTO {

	private Long id;
	private String email;
	
	public EmailDTO(Email e) {
		this.id = e.getId();
		this.email = e.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	
}
