package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String name;
	private String email;
	private String password;
	private Integer typePermission;
	private CompanyDTO company;
	
}
