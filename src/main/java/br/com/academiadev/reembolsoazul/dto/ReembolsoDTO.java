package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class ReembolsoDTO {

	private Long id;
	private String nome;
	private String categoria;
	private String status;
	private String data;
	private String pessoaNome;
	private String email;
	private String valor;
}
