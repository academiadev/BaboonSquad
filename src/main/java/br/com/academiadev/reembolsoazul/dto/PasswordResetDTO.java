package br.com.academiadev.reembolsoazul.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetDTO {

	public String newPassword;
	public Long code;
	public String emailUser;

}
