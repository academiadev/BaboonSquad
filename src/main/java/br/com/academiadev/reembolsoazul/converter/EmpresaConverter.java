package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.EmpresaDTO;
import br.com.academiadev.reembolsoazul.model.Empresa;

@Component
public class EmpresaConverter implements Converter<Empresa, EmpresaDTO> {

	@Override
	public EmpresaDTO toDTO(Empresa entity) {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCode(entity.getCodigo());
		empresaDTO.setName(entity.getNome());
		return empresaDTO;
	}

	@Override
	public Empresa toEntity(EmpresaDTO dto) {
		Empresa empresa = new Empresa();

		if (dto.getName() != null) {
			empresa.setNome(dto.getName());
		} else {
			empresa.setCodigo(dto.getCode());
		}
		return empresa;
	}

}
