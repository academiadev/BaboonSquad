package com.academiadev.reembolsoazul.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academiadev.reembolsoazul.dto.PessoaDTO;
import com.academiadev.reembolsoazul.model.Pessoa;
import com.academiadev.reembolsoazul.model.TipoPermissao;

@Component
public class PessoaConverter implements Converter<Pessoa, PessoaDTO>{

	@Autowired
	private EmpresaConverter empresaConverter;
	
	@Override
	public PessoaDTO toDTO(Pessoa entity) {
		PessoaDTO dto = new PessoaDTO();
		dto.setEmail(entity.getEmail());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		dto.setTipoPermissao(entity.getTipoPermissao().getId());
		dto.setEmpresa(empresaConverter.toDTO(entity.getEmpresa()));
		return dto;
	}

	@Override
	public Pessoa toEntity(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail(dto.getEmail());
		pessoa.setNome(dto.getNome());
		pessoa.setSenha(dto.getSenha());
		pessoa.setTipoPermissao(TipoPermissao.convertToEnum(dto.getTipoPermissao()));
		pessoa.setEmpresa(empresaConverter.toEntity(dto.getEmpresa()));
		return pessoa;
	}

}
