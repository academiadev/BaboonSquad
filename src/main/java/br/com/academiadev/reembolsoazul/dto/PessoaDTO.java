package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class PessoaDTO {

	private String nome;
	private String email;
	private String senha;
	private Integer tipoPermissao;
	private EmpresaDTO empresa;
}
