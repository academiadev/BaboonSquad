package com.academiadev.reembolsoazul.dto;

public class PessoaDTO {

	private String nome;
	private String email;
	private String senha;
	private String senhaRepetida;
	private Integer tipoPermissao;
	private EmpresaDTO empresa;

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

	public Integer getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(Integer tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

}
