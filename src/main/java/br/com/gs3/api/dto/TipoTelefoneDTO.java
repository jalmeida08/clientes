package br.com.gs3.api.dto;

public class TipoTelefoneDTO {
	
	private Integer id;
	private String tipo;
	
	
	public TipoTelefoneDTO(Integer id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}


	public String getTipo() {
		return tipo;
	}
	
	

}
