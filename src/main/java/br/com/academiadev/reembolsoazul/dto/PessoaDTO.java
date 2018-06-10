package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class PessoaDTO {

	private String name;
	private String email;
	private String password;
	private Integer typePermission;
	private EmpresaDTO company;


}
