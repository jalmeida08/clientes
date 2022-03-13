package br.com.gs3.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> listaTipoTelefone() {
		List<TipoTelefoneDTO> recuperaListaTelefone = new TipoTelefoneVO().recuperaListaTelefone();
		return ResponseEntity.ok(recuperaListaTelefone);
	}
	
	@PutMapping("/{idTelefone}")
	@Transactional
	public ResponseEntity<?> editaTelefone(@PathVariable("idTelefone") Long idTelefone, @RequestBody NovoTelefoneForm telefoneForm) {
		this.telefoneService.editaTelefone(idTelefone, telefoneForm);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idTelefone}")
	public ResponseEntity<?> removeReletone(@PathVariable Long idTelefone){
		this.telefoneService.removeTelefone(idTelefone);
		return ResponseEntity.ok().build();
	}

}
