package br.com.gs3.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gs3.infra.model.Pessoa;

public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;
	private List<TelefoneDTO> listaTelefone = new ArrayList<TelefoneDTO>();
	private List<EmailDTO> listaEmail = new ArrayList<EmailDTO>(); 
	
	public ClienteDTO(Pessoa p) {
		id = p.getId();
		nome = p.getNome();
		cpf = p.getCpf().toString();
		listaTelefone = p.getContato().getTelefone().stream().map(TelefoneDTO::new).collect(Collectors.toList());
		listaEmail = p.getContato().getEmail().stream().map(EmailDTO::new).collect(Collectors.toList());
		if(p.getEndereco() != null) this.endereco = new EnderecoDTO(p.getEndereco());
	}


	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public List<TelefoneDTO> getListaTelefone() {
		return listaTelefone;
	}
	public List<EmailDTO> getListaEmail() {
		return listaEmail;
	}
}
