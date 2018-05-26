package com.academiadev.reembolsoazul.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academiadev.reembolsoazul.converter.PessoaConverter;
import com.academiadev.reembolsoazul.dto.PessoaDTO;
import com.academiadev.reembolsoazul.model.Empresa;
import com.academiadev.reembolsoazul.model.Pessoa;
import com.academiadev.reembolsoazul.model.TipoPermissao;
import com.academiadev.reembolsoazul.repository.EmpresaRepository;
import com.academiadev.reembolsoazul.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaConverter pessoaConverter;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public void cadastrar(PessoaDTO pessoaDto) {
		validaIgual(pessoaDto.getSenha(), pessoaDto.getSenhaRepetida());
		Pessoa pessoa = pessoaConverter.toEntity(pessoaDto);
		validaDigitos(pessoa.getSenha());
		validaEmail(pessoaDto.getEmail());
		setarEmpresaParaCadastro(pessoa);
		if(pessoa.getTipoPermissao() == TipoPermissao.ADMIN) {
			Empresa empresa = pessoa.getEmpresa();
			empresa.setCodigo(132131);
			empresaRepository.save(empresa);
		}
		pessoaRepository.save(pessoa);
	}

	private Pessoa setarEmpresaParaCadastro(Pessoa pessoa) {
		if (pessoa.getTipoPermissao() == TipoPermissao.USER) {
			pessoa.setEmpresa(empresaRepository.findByCodigo(pessoa.getEmpresa().getCodigo()));
		}
		return pessoa;

	}

	private Boolean validaEmail(String email) {
		Pattern pattern = Pattern.compile("^[a-zA-z].{8,}$");
		return pattern.matcher(email).matches();
	}

	private Boolean validaIgual(String senha, String senhaRepetida) {
		return senha == senhaRepetida ? true : false;
	}

	private Boolean validaDigitos(String senha) {
		Pattern pattern = Pattern.compile("^[a-zA-z].{8,}$");
		return pattern.matcher(senha).matches();
	}

}
