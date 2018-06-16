package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class RefundDTO {

	private Long id;
	private String name;
	private String category;
	private String status;
	private String date;
	private String userName;
	private String email;
	private String value;
}
