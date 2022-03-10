package br.com.gs3.infra.exception;

public class ParametroNaoInformadoException extends RuntimeException{

	private static final long serialVersionUID = -3068737180843339427L;
	
	public ParametroNaoInformadoException(String message ) {
		super(message);
	}

	
}