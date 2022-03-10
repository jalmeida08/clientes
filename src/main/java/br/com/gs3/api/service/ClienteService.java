package br.com.gs3.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.form.pessoa.NovaPessoaForm;
import br.com.gs3.infra.model.Pessoa;
import br.com.gs3.infra.repository.ClienteRepository;
import br.com.gs3.infra.repository.ContatoRepository;
import br.com.gs3.infra.repository.EmailRepository;
import br.com.gs3.infra.repository.TelefoneRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	public void salvaDadosCliente(NovaPessoaForm pessoaForm) {
		Pessoa p = this.clienteRepository.save(pessoaForm.toPessoa());
//		this.contatoRepository.save(pessoaForm.toContato(p));
	}
	
	public List<Pessoa> listaDadosCliente() {
		return this.clienteRepository.findAll();
		
	}
	
	

}
