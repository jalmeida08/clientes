package br.com.gs3.api.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.gs3.infra.model.Contato;
import br.com.gs3.infra.model.Telefone;
import br.com.gs3.infra.model.TipoTelefone;

public class NovoTelefoneForm {
	
	@NotBlank @Length(min= 2,  max = 2, message = "Digite um DDD válido")
	private String ddd;
	@NotBlank @Length(min= 8,  max = 9, message = "Digite um número de telefone válido")
	private String numero;
	@NotBlank(message = "Obrigatório a escolha de um tipo de telefone")
	private TipoTelefone tipoTelefone;
	
	public Telefone toTelefone(Contato c) {
		Telefone t = new Telefone();
		t.setDdd(Integer.parseInt(this.ddd));
		t.setNumTelefone(Integer.parseInt(this.numero));
		t.setTipoTelefone(this.tipoTelefone);
		t.setContato(c);
		return t;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public String toString() {
		return "NovoTelefoneForm [ddd=" + ddd + ", numero=" + numero + ", tipoTelefone=" + tipoTelefone + "]";
	}
	
	
	
	

}
