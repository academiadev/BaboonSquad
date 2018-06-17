package br.com.academiadev.reembolsoazul.model;

public enum RefundCategory {
	
	OUTROS(0, "Outros"),
	HOSPEDAGEM(1, "Hospedagem"), 
	TRANSPORTE(2, "Transporte"), 
	ALIMENTACAO(3, "Alimentação");
	
	private Integer id;
	private String descricao;
	
	RefundCategory(Integer id, String descricao) {
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
