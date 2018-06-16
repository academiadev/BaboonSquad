package br.com.academiadev.reembolsoazul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authority")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	public Authority(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	@JsonIgnore
	public String getNome() {
		return name;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

}
