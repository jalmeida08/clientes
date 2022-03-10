package br.com.gs3.api.form.endereco;

import javax.persistence.Column;
import javax.persistence.Version;

import br.com.gs3.infra.model.Pessoa;

public class AdiconaEnderecoForm {

	private Pessoa pessoa;
	
	private Long cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
	private String complemento;
	
}
