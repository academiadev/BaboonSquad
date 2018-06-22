package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class UserAlterDTO {

	private String email;
	private String newEmail;
	private String nome;
}
