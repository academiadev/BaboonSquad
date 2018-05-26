package com.academiadev.reembolsoazul.model;

public enum CategoriaReembolso {
	
	OUTROS(0, "Outros"),
	HOSPEDAGEM(1, "Hospedagem"), 
	TRANSPORTE(2, "Transporte"), 
	ALIMENTACAO(3, "Alimentacao");
	
	private Integer id;
	private String descricao;
	
	CategoriaReembolso(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}