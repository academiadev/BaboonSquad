package br.com.academiadev.reembolsoazul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.PessoaDTO;
import br.com.academiadev.reembolsoazul.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	public PessoaService pessoaService;

	@PostMapping(value = "/gravar")
	public void cadastrar(PessoaDTO pessoaDTO) {
		pessoaService.cadastrar(pessoaDTO);
	}
}
