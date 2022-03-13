package br.com.gs3.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gs3.api.dto.ClienteDTO;
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
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> adicionaPessoa(@RequestBody @Valid NovaPessoaForm pessoaForm) {
		this.clienteService.salvaDadosCliente(pessoaForm);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{idCliente}/endereco")
	@Transactional
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> adicionaEnderecoCliente(@PathVariable("idCliente") Long idCliente, @RequestBody NovoEnderecoForm enderecoForm) {
		this.clienteService.adicionaEndereco(idCliente, enderecoForm);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public ResponseEntity<?> listaDadosCliente(){
		return ResponseEntity.ok(this.clienteService.listaDadosCliente());
	}
//	
//	@GetMapping("")
//	public ResponseEntity<?> listaCliente(){
//		return ResponseEntity.ok(this.clienteService.listaDadosCliente());
//	}
	
	@GetMapping("/{idCliente}")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public ResponseEntity<?> getCliente(@PathVariable("idCliente") Long idCliente){
		return ResponseEntity.ok(new ClienteDTO(this.clienteService.getCliente(idCliente)));
	}
	
	@DeleteMapping("/{idCliente}")
	@Transactional
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> removeCliente(@PathVariable("idCliente") Long idCliente){
		this.clienteService.removeCliente(idCliente);
		return ResponseEntity.ok().build();
	}
	
}
