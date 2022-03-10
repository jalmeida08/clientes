package br.com.gs3.infra.exception;

public class DadosNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -3068737180843339427L;
	
	public DadosNaoEncontradoException() {
		super("O parametro informado não foi encontrado na base de dados");
	}

	
}