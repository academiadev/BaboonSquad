package com.academiadev.reembolsoazul.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.reembolsoazul.controller.UserController;
import br.com.academiadev.reembolsoazul.dto.CompanyDTO;
import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.exception.CompanyExecption;
import br.com.academiadev.reembolsoazul.exception.EmailExecption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaControllerTeste {

	@Autowired
	private UserController pessoaController;
	
	@Test
	public void testaGravarAdmin() throws EmailExecption, CompanyExecption {
		CompanyDTO empresaDTO = new CompanyDTO();
		empresaDTO.setName("Empresa das Empresas");
			
		UserDTO pessoaDTO = new UserDTO();
		pessoaDTO.setEmail("Jao@acom");
		pessoaDTO.setName("Jpones");
		pessoaDTO.setPassword("aaaaaaaaaa");
		pessoaDTO.setTypePermission(1);
		pessoaDTO.setCompany(empresaDTO);
		pessoaController.register(pessoaDTO);
		
	}
	
	@Test
	public void testaGravarUser() throws EmailExecption, CompanyExecption {
		CompanyDTO empresaDTO = new CompanyDTO();
		empresaDTO.setCode(132131);
			
		UserDTO pessoaDTO = new UserDTO();
		pessoaDTO.setEmail("Jao");
		pessoaDTO.setName("Jpones");
		pessoaDTO.setPassword("****");
		pessoaDTO.setTypePermission(1);
		pessoaDTO.setCompany(empresaDTO);
		pessoaController.register(pessoaDTO);
	}
}
