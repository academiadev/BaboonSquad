package br.com.academiadev.reembolsoazul.exception;

import lombok.Getter;

@Getter
public class LoginExecption extends APIException {

	private static final long serialVersionUID = 1L;

	public LoginExecption(String message, String errorKey) {
		super(message, errorKey);
	}

}
