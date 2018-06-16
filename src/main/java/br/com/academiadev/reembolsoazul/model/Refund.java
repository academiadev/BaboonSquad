package br.com.academiadev.reembolsoazul.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "refund")
@Data
public class Refund implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	@NotNull
	private String name;
	@Column
	private RefundCategory category;
	@Column
	private RefundStatus status;
	@Column 
	private LocalDate date;
	@Column
	private BigDecimal value;
	@ManyToOne
	private User user;
}
