package br.com.gs3.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.form.NovoTelefoneForm;
import br.com.gs3.infra.exception.DadosNaoEncontradoException;
import br.com.gs3.infra.exception.ParametroNaoInformadoException;
import br.com.gs3.infra.model.Telefone;
import br.com.gs3.infra.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	private Telefone getTelefone(Long idTelefone) {
		if(idTelefone == null)
			throw new ParametroNaoInformadoException("É obrigatóri que informe o parametro do cliente");
		return this.telefoneRepository
				.findById(idTelefone)
				.orElseThrow(() -> new DadosNaoEncontradoException());
		
	}
	
	public void editaTelefone(Long idTelefone, NovoTelefoneForm telefoneForm) {
		Telefone t = getTelefone(idTelefone);
		t.setDdd(Integer.valueOf(telefoneForm.getDdd()));
		t.setNumTelefone(Integer.valueOf(telefoneForm.getNumero()));
		t.setTipoTelefone(telefoneForm.getTipoTelefone());
		
	}

	public void removeTelefone(Long idTelefone) {
		Telefone t = getTelefone(idTelefone);
		this.telefoneRepository.delete(t);
	}

}
