package br.com.academiadev.reembolsoazul.model;

import java.io.Serializable;
<<<<<<< HEAD
=======
import java.math.BigDecimal;
import java.time.LocalDate;
>>>>>>> 73ff43ad8cd4c74d41f33d043578cef2dc63a516

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

<<<<<<< HEAD
=======
@Data
>>>>>>> 73ff43ad8cd4c74d41f33d043578cef2dc63a516
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
	private LocalDate data;
	@Column
	private BigDecimal valor;
	@Column 
	@NotNull
<<<<<<< HEAD
	private User usuario;


=======
	private Pessoa usuario;
>>>>>>> 73ff43ad8cd4c74d41f33d043578cef2dc63a516
}
