package com.academiadev.reembolsoazul.dto;

public class PessoaDTO {

	private String nome;
	private String email;
	private String senha;
	private String tipoPermissao;
	private String codigoEmpresa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(String tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

}
