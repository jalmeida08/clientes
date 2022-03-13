package br.com.gs3.dominio.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.gs3.api.dto.TipoTelefoneDTO;
import br.com.gs3.infra.model.TipoTelefone;

public class TipoTelefoneVO {
	
	private List<TipoTelefoneDTO> listTipoTelefone = new ArrayList<>();
	
	public List<TipoTelefoneDTO> recuperaListaTelefone() {
		listTipoTelefone.add(new TipoTelefoneDTO(1, TipoTelefone.CELULAR.name()));
		listTipoTelefone.add(new TipoTelefoneDTO(2, TipoTelefone.COMERCIAL.name()));
		listTipoTelefone.add(new TipoTelefoneDTO(3, TipoTelefone.RESIDENCIAL.name()));
		return listTipoTelefone;
	}

}
