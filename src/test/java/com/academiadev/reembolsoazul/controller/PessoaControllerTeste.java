package com.academiadev.reembolsoazul.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.academiadev.reembolsoazul.dto.EmpresaDTO;
import com.academiadev.reembolsoazul.dto.PessoaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaControllerTeste {

	@Autowired
	private PessoaController pessoaController;
	
	@Test
	public void testaGravarAdmin() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setNome("Empresa das Empresas");
			
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setEmail("Jao");
		pessoaDTO.setNome("Jpones");
		pessoaDTO.setSenha("****");
		pessoaDTO.setSenhaRepetida("****");
		pessoaDTO.setTipoPermissao(0);
		pessoaDTO.setEmpresa(empresaDTO);
		pessoaController.cadastrar(pessoaDTO);
	}
	
	@Test
	public void testaGravarUser() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCodigo(132131);
			
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setEmail("Jao");
		pessoaDTO.setNome("Jpones");
		pessoaDTO.setSenha("****");
		pessoaDTO.setSenhaRepetida("****");
		pessoaDTO.setTipoPermissao(1);
		pessoaDTO.setEmpresa(empresaDTO);
		pessoaController.cadastrar(pessoaDTO);
	}
}
