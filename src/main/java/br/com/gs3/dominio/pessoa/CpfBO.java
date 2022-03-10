package br.com.gs3.dominio.pessoa;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CpfBO {
	
	@NotBlank @Length(min = 11, max = 11, message = "CPF INCORRETO") 
	private Integer cpf;
	
	public CpfBO(Integer cpf) {
		
	}

}
