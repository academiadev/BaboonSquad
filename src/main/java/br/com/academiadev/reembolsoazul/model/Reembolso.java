package br.com.academiadev.reembolsoazul.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reembolsos")
public class Reembolso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	@NotNull
	private String nome;
	@Column
	private CategoriaReembolso categoria;
	@Column
	private StatusReembolso status;

	@Column
	@NotNull
	private Pessoa usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaReembolso getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaReembolso categoria) {
		this.categoria = categoria;
	}

	public StatusReembolso getStatus() {
		return status;
	}

	public void setStatus(StatusReembolso status) {
		this.status = status;
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

}
