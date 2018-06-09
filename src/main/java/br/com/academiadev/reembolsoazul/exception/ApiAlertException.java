package br.com.academiadev.reembolsoazul.exception;

import lombok.Getter;

@Getter
public class ApiAlertException extends APIException {

	private static final long serialVersionUID = 1L;

	public ApiAlertException(String message, String errorKey) {
		super(message, errorKey);
	}

}
