package br.com.gs3.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gs3.api.form.NovoTelefoneForm;
import br.com.gs3.dominio.bo.TelefoneBO;
import br.com.gs3.infra.exception.DadosNaoEncontradoException;
import br.com.gs3.infra.exception.NegocioException;
import br.com.gs3.infra.exception.ParametroNaoInformadoException;
import br.com.gs3.infra.exception.RegraNegocialException;
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
	
	private List<Telefone> getListaTelefoneCliente(Long idCliente) {
		return this.telefoneRepository.listaTelefoneCliente(idCliente);
	}
	
	public void editaTelefone(Long idTelefone, NovoTelefoneForm telefoneForm) {
		Telefone t = getTelefone(idTelefone);
		t.setDdd(Integer.valueOf(telefoneForm.getDdd()));
		t.setNumTelefone(Integer.valueOf(telefoneForm.getNumero()));
		t.setTipoTelefone(telefoneForm.getTipoTelefone());
		
	}

	public void removeTelefone(Long idTelefone, Long idCliente) {
		TelefoneBO telefoneBo = new TelefoneBO();
		try {
			telefoneBo.isPermitidoRemoverTelefoneCliente(this.getListaTelefoneCliente(idCliente));
			Telefone t = getTelefone(idTelefone);
			this.telefoneRepository.delete(t);
		} catch (NegocioException e) {
			throw new RegraNegocialException(e.getMessage());
		}
	}

}
