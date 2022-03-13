package br.com.gs3.dominio.bo;

import java.util.List;

import br.com.gs3.infra.exception.NegocioException;
import br.com.gs3.infra.model.Email;

public class EmailBO {
	
	public boolean isPermitidoRemoverEmailCliente(List<Email> listaEmailCliente) throws NegocioException {
		if(listaEmailCliente.size() > 1)
			return true;
		throw new NegocioException("Não foi possível remover o e-mail selecionado, cliente precisa ter no mínimo 1 (um) para contato.");
	}
	
}
