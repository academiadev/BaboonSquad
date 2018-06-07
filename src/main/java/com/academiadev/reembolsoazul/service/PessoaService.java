package com.academiadev.reembolsoazul.service;

import java.util.Random;
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
		if (validaIgual(pessoaDto.getSenha(), pessoaDto.getSenhaRepetida())) {
			Pessoa pessoa = pessoaConverter.toEntity(pessoaDto);
			if (validaDigitos(pessoa.getSenha()) && validaEmail(pessoaDto.getEmail())) {
				setarEmpresaParaCadastro(pessoa);
				if (pessoa.getTipoPermissao() == TipoPermissao.ADMIN) {
					gravaEmpresa(pessoa);
				}
				pessoaRepository.save(pessoa);
			}
		}

	}

	private void gravaEmpresa(Pessoa pessoa) {
		Empresa empresa = pessoa.getEmpresa();
		do {
			Random random = new Random();
			empresa.setCodigo(random.nextInt(99999));
		} while (empresaRepository.existsByCodigo(empresa.getCodigo()));
		empresaRepository.save(empresa);
	}

	private Pessoa setarEmpresaParaCadastro(Pessoa pessoa) {
		if (pessoa.getTipoPermissao() == TipoPermissao.USER) {
			pessoa.setEmpresa(empresaRepository.findByCodigo(pessoa.getEmpresa().getCodigo()));
		}
		return pessoa;

	}

	private Boolean validaEmail(String email) {
		Pattern pattern = Pattern.compile("^\\w*(\\.\\w*)?@\\w*\\.[a-z]+(\\.[a-z]+)?$");
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
