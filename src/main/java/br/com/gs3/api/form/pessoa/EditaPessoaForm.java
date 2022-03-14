package br.com.gs3.api.form.pessoa;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.gs3.api.form.NovoEnderecoForm;
import br.com.gs3.infra.model.Endereco;
import br.com.gs3.infra.model.Pessoa;

public class EditaPessoaForm {
	
	@NotBlank(message = "Nome obrigatório")
	@Length(min= 3,  max = 100, message = "Nome deve conter no mínimo de 3 e no máximo de 100 caracteres")
	private String nome;

	private NovoEnderecoForm endereco;
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(NovoEnderecoForm endereco) {
		this.endereco = endereco;
	}


	public Pessoa atualizaDadosCliente(Pessoa p) {
		p.setNome(this.nome);
		Endereco e = p.getEndereco();
		
		// PARA NÃO OCORRER NULLPOINTER EXCEPTION NO ENDERECO QUANDO NÃO CADASTRADO INICIALMENTE;
		if(p.getEndereco() == null)
			e = new Endereco();
		
		if(endereco != null)
			p.setEndereco(endereco.atualizaEnderecoCliente(e, p));
		
			
		return p;
	}
}
