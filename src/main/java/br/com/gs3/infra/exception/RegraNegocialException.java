package br.com.gs3.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RegraNegocialException extends RuntimeException {

	private static final long serialVersionUID = -3068737180843339427L;

	public RegraNegocialException(String message) {
			super(message);
		}

}
