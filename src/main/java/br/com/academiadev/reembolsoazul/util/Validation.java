package br.com.academiadev.reembolsoazul.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	public Boolean validEmail(String email) {
		Pattern pattern = Pattern.compile("^\\w*([\\._]{0,}\\w*){1,}@\\w*\\.[a-z]+(\\.[a-z]+)?$");
		return pattern.matcher(email).matches();
	}
	
	private Boolean validPassword(String senha) {
		Pattern pattern = Pattern.compile("^[a-zA-z].{8,}$");
		return pattern.matcher(senha).matches();
	}
}
