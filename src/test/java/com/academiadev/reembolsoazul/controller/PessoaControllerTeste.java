package com.academiadev.reembolsoazul.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.academiadev.reembolsoazul.controller.PessoaController;
import br.com.academiadev.reembolsoazul.dto.EmpresaDTO;
import br.com.academiadev.reembolsoazul.dto.PessoaDTO;
import br.com.academiadev.reembolsoazul.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaControllerTeste {

	@Autowired
	private PessoaController pessoaController;
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void testaGravarAdmin() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setName("Empresa das Empresas");
			
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setEmail("Jao@acom");
		pessoaDTO.setName("Jpones");
		pessoaDTO.setPassword("aaaaaaaaaa");
		pessoaDTO.setTypePermission(1);
		pessoaDTO.setCompany(empresaDTO);
		pessoaController.cadastrar(pessoaDTO);
		
		emailService.enviar();
	}
	
	@Test
	public void testaGravarUser() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCode(132131);
			
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setEmail("Jao");
		pessoaDTO.setName("Jpones");
		pessoaDTO.setPassword("****");
		pessoaDTO.setTypePermission(1);
		pessoaDTO.setCompany(empresaDTO);
		pessoaController.cadastrar(pessoaDTO);
	}
}
