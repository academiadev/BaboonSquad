package br.com.academiadev.reembolsoazul.model;

public enum RefundStatus {
	APROVADO(0, "Aprovado"),
	REPROVADO(1, "Reprovado"),
	AGUARDANDO(2, "Aguardando Avalia��o");
	
	private Integer id;
	private String descricao;
	
	RefundStatus(Integer id, String descricao){
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
