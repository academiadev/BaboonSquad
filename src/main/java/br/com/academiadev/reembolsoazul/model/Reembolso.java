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

@Data
@Entity
@Table(name = "reembolso")
public class Reembolso implements Serializable {
	
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

}
