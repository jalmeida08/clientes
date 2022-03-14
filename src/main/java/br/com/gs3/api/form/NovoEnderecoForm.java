package br.com.gs3.api.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.gs3.infra.model.Endereco;
import br.com.gs3.infra.model.Pessoa;

public class NovoEnderecoForm {
	
	@NotNull @NotBlank(message = "CEP obrigatório") @Length(min=8, max = 8)
	private Long cep;
	@NotBlank(message = "Logradouro obrigatório")
	private String logradouro;
	@NotBlank(message = "Bairro obrigatório")
	private String bairro;
	@NotBlank(message = "Cidade obrigatório")
	private String cidade;
	@NotBlank(message = "UF obrigatório")
	private String uf;
	
	private String complemento;
	
	public Endereco toEndereco(Pessoa p) {
		Endereco e = new Endereco();
		e.setCep(cep);
		e.setBairro(bairro);
		e.setCidade(cidade);
		e.setComplemento(complemento);
		e.setLogradouro(logradouro);
		e.setUf(uf);
		e.setPessoa(p);
		return e;
	}
	

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public Endereco atualizaEnderecoCliente(Endereco e, Pessoa p) {
		e.setCep(this.cep);
		e.setBairro(this.bairro);
		e.setCidade(this.cidade);
		e.setComplemento(this.complemento);
		e.setLogradouro(this.logradouro);
		e.setUf(this.uf);
		e.setPessoa(p);
		return e;
	}


}
