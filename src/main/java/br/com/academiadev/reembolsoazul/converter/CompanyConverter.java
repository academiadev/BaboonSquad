package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.CompanyDTO;
import br.com.academiadev.reembolsoazul.model.Company;

@Component
public class CompanyConverter implements Converter<Company, CompanyDTO> {

	@Override
	public CompanyDTO toDTO(Company entity) {
		CompanyDTO empresaDTO = new CompanyDTO();
		empresaDTO.setCode(entity.getCode());
		empresaDTO.setName(entity.getName());
		return empresaDTO;
	}

	@Override
	public Company toEntity(CompanyDTO dto) {
		Company empresa = new Company();

		if (dto.getName() != null) {
			empresa.setName(dto.getName());
		} else {
			empresa.setCode(dto.getCode());
		}
		return empresa;
	}

}
