package br.com.gs3.api.dto;

import br.com.gs3.infra.model.Telefone;

public class TelefoneDTO {
	
	private Long id;
	private Integer ddd;
	private Integer numero;
	private String tipoTelefone;
	
	public TelefoneDTO(Telefone t) {
		this.id = t.getId();
		this.ddd = t.getDdd();
		this.numero = t.getNumTelefone();
		this.tipoTelefone = t.getTipoTelefone().name();
	}

	
	public Long getId() {
		return id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}
	
	

}
