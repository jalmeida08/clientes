package br.com.gs3.api.form.pessoa;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.gs3.api.form.NovoEmailForm;
import br.com.gs3.api.form.NovoTelefoneForm;
import br.com.gs3.infra.model.Contato;
import br.com.gs3.infra.model.Email;
import br.com.gs3.infra.model.Pessoa;
import br.com.gs3.infra.model.Telefone;

public class NovaPessoaForm {
	
	@NotBlank @Length(min= 3,  max = 100, message = "Mínimo de 3 e máximo de 100 caracteres")
//	@Pattern(regexp = "/[^a-zA-Z 0-9]/g")
	private String nome;
	@NotBlank
	@CPF(message = "Número de CPF inválido")
	@Length(message = "CPF INCORRETO")
	private String cpf;
	
	@Size(min = 1)
	private List<NovoTelefoneForm> listaTelefone = new ArrayList<NovoTelefoneForm>();
	
	@Size(min = 1)
	private List<NovoEmailForm> listaEmail = new ArrayList<NovoEmailForm>();
	
	public Pessoa toPessoa() {
		Pessoa p = new Pessoa();
		p.setCpf(Long.valueOf(this.cpf));
		p.setNome(this.nome);
		p.setContato(toContato(p));
		return p;
	}
	
	private Contato toContato(Pessoa p) {
		Contato c = new Contato();
		List<Telefone> lstTelefone = new ArrayList<>();
		List<Email> lstEmail = new ArrayList<>();
		
		listaTelefone.stream().forEach(t -> lstTelefone.add(t.toTelefone(c)));
		listaEmail.stream().forEach(e -> lstEmail.add(e.toEmail(c)));
		
		c.setTelefone(lstTelefone);
		c.setEmail(lstEmail);
		c.setPessoa(p);
		return c;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setListaTelefone(List<NovoTelefoneForm> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public void setListaEmail(List<NovoEmailForm> listaEmail) {
		this.listaEmail = listaEmail;
	}

	@Override
	public String toString() {
		return "NovaPessoaForm [nome=" + nome + ", cpf=" + cpf + ", listaTelefone=" + listaTelefone + ", listaEmail="
				+ listaEmail + "]";
	}

	
	
	
	
}
