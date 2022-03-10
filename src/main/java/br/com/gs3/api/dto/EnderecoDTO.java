package br.com.gs3.api.dto;

import br.com.gs3.infra.model.Endereco;
import br.com.gs3.infra.model.Pessoa;

public class EnderecoDTO {
	
	
	private Long id;
	private Long cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	
	public EnderecoDTO(Endereco e) {
		this.id = e.getId();
		this.cep = e.getCep();
		this.logradouro = e.getLogradouro();
		this.bairro = e.getBairro();
		this.cidade = e.getCidade();
		this.uf = e.getUf();
		this.complemento = e.getComplemento();
	}

	public Long getId() {
		return id;
	}

	public Long getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getComplemento() {
		return complemento;
	}
	
	
}
