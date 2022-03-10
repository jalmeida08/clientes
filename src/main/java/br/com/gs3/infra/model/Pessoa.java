package br.com.gs3.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Min(value = 3, message = "Mínimo de 3 caracteres")
	@Max(value = 100, message = "Máximo até 100 caracteres")
	private String nome;
	
	@Column(name="num_cpf", length = 11, nullable = false)
	private Integer cpf;

	@OneToOne(mappedBy = "pessoa")
	private Endereco endereco;
	
	@OneToOne(mappedBy = "pessoa")
	private Contato contato;
	
	@Version
	private Long versao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Long getId() {
		return id;
	}

	public Long getVersao() {
		return versao;
	}
	
	
}
