package br.com.gs3.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gs3.api.form.NovoEnderecoForm;
import br.com.gs3.api.form.pessoa.NovaPessoaForm;
import br.com.gs3.api.service.ClienteService;


@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	

	@PostMapping
	@Transactional
	public ResponseEntity<?> adicionaPessoa(@RequestBody @Valid NovaPessoaForm pessoaForm) {
		this.clienteService.salvaDadosCliente(pessoaForm);
		return ResponseEntity.ok("Sucesso");
	}
	
	@PostMapping("/{idCliente}/endereco")
	@Transactional
	public ResponseEntity<?> adicionaEnderecoCliente(@PathVariable("idCliente") Long idCliente, @RequestBody NovoEnderecoForm enderecoForm) {
		this.clienteService.adicionaEndereco(idCliente, enderecoForm);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<?> listaDadosCliente(){
		return ResponseEntity.ok(this.clienteService.listaDadosCliente());
	}
	
}
