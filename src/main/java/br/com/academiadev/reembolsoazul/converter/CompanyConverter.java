package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.CompanyDTO;
import br.com.academiadev.reembolsoazul.model.Company;

@Component
public class CompanyConverter implements Converter<Company, CompanyDTO> {

	@Override
	public CompanyDTO toDTO(Company entity) {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCode(entity.getCode());
		companyDTO.setName(entity.getName());
		return companyDTO;
	}

	@Override
	public Company toEntity(CompanyDTO companyDto) {
		Company company = new Company();

		if (companyDto.getName() != null) {
			company.setName(companyDto.getName());
		} else {
			company.setCode(companyDto.getCode());
		}
		return company;
	}

}
