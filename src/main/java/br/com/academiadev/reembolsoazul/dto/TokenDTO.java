package br.com.academiadev.reembolsoazul.dto;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {

	private String access_token;
	private Long expires_in;

}