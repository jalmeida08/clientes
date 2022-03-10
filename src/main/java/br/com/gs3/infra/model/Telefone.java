package br.com.gs3.infra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "telefone")
public class Telefone{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "num_ddd", nullable = false, length = 2)
	private Integer ddd;
	
	@Column(name = "num_telefone", nullable = false, length = 9)
	private Integer numTelefone;

	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	
	@ManyToOne
	@JoinColumn(name="contato_id")
	private Contato contato;
	
	@Version
	private Long versao;

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(Integer numTelefone) {
		this.numTelefone = numTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
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
