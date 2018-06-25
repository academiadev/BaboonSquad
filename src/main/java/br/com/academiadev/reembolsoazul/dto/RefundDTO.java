package br.com.academiadev.reembolsoazul.dto;

import lombok.Data;

@Data
public class RefundDTO {

	private Long id;
	private String name;
	private Integer category;
	private Integer status;
	private String date;
	private String userName;
	private String value;
	private String file;
	private Boolean showForUser;
}
