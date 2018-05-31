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
	
	private LocalDate dataCadastro;
	
	private LocalDate dataGasto;
	
	@Column
	@NotNull
	private Pessoa usuario;

}
