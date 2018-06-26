package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class UserAlterDTO {

	private Long userId;
	private String newEmail;
	private String name;
}
