package br.com.gs3.dominio.bo;

import java.util.List;

import br.com.gs3.infra.exception.NegocioException;
import br.com.gs3.infra.model.Telefone;

public class TelefoneBO {

	public boolean isPermitidoRemoverTelefoneCliente(List<Telefone> listaTelefoneCliente) throws NegocioException {
		if(listaTelefoneCliente.size() > 1)
			return true;
		throw new NegocioException("Não foi possível remover o contato selecionado, cliente precisa ter no mínimo 1 (um) telefone para contato.");
	}
	
	

}
