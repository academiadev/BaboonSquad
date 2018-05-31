package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class ReembolsoDto {

	private Long id;
	private String nome;
	private String categoria;
	private String status;
	private String dataCadastro;
	private String dataGasto;
	
	}
