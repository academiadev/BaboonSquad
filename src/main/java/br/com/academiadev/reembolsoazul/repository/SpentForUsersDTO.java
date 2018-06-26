package br.com.academiadev.reembolsoazul.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpentForUsersDTO {

	private String value;
	private String name;
	private String email;
}
