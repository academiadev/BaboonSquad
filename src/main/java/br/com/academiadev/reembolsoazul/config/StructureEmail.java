package br.com.academiadev.reembolsoazul.config;

import lombok.Data;

@Data
public class StructureEmail {

	private String sender;
	private String recipient;
	private String subject;
	private String body;
}
