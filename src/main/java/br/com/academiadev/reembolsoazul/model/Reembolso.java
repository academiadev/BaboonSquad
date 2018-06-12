package br.com.academiadev.reembolsoazul.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "reembolsos")
@Data
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
	private User usuario;


}
