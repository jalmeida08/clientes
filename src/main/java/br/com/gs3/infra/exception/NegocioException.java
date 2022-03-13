package br.com.gs3.infra.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1579153690637400848L;

	public NegocioException(String message) {
		super(message);
	}

}
