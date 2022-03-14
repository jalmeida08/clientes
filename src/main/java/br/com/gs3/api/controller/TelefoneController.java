package br.com.gs3.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gs3.api.dto.TipoTelefoneDTO;
import br.com.gs3.api.form.NovoTelefoneForm;
import br.com.gs3.api.service.TelefoneService;
import br.com.gs3.dominio.vo.TipoTelefoneVO;

@RestController
@RequestMapping("telefone")
public class TelefoneController {
	
	@Autowired
	private TelefoneService telefoneService;
	
	@GetMapping("/lista-tipo-telefone")
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public ResponseEntity<?> listaTipoTelefone() {
		List<TipoTelefoneDTO> recuperaListaTelefone = new TipoTelefoneVO().recuperaListaTelefone();
		return ResponseEntity.ok(recuperaListaTelefone);
	}
	
	@PutMapping("/{idTelefone}")
	@Transactional
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> editaTelefone(@PathVariable("idTelefone") Long idTelefone, @RequestBody @Valid NovoTelefoneForm telefoneForm) {
		this.telefoneService.editaTelefone(idTelefone, telefoneForm);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idTelefone}/{idCliente}")
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> removeReletone(@PathVariable Long idTelefone, @PathVariable Long idCliente){
		this.telefoneService.removeTelefone(idTelefone, idCliente);
		return ResponseEntity.ok().build();
	}

}
