package br.com.gs3.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.dto.ClienteDTO;
import br.com.gs3.api.form.NovoEnderecoForm;
import br.com.gs3.api.form.pessoa.NovaPessoaForm;
import br.com.gs3.infra.exception.DadosNaoEncontradoException;
import br.com.gs3.infra.exception.ParametroNaoInformadoException;
import br.com.gs3.infra.model.Endereco;
import br.com.gs3.infra.model.Pessoa;
import br.com.gs3.infra.repository.ClienteRepository;
import br.com.gs3.infra.repository.EnderecoRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public void salvaDadosCliente(NovaPessoaForm pessoaForm) {
		this.clienteRepository.save(pessoaForm.toPessoa());
	}
	
	public List<ClienteDTO> listaDadosCliente() {
		List<Pessoa> findAll = this.clienteRepository.findAll();
		return findAll.stream().map(ClienteDTO::new).collect(Collectors.toList());
		
	}

	public void adicionaEndereco( Long idCliente, NovoEnderecoForm enderecoForm) {
		final Pessoa p; 
		if(idCliente > 0)
			p = clienteRepository.findById(idCliente).orElseThrow(() -> new DadosNaoEncontradoException());
		else 
			throw new ParametroNaoInformadoException("É obrigatóri que informe o parametro do cliente");
		
		Endereco e = enderecoForm.toEndereco(p);
		this.enderecoRepository.save(e);
	}
	
	

}
