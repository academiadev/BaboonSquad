package br.com.academiadev.reembolsoazul.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.model.User;

@Component
public class UserConverter implements Converter<User, UserDTO>{

	@Autowired
	private CompanyConverter empresaConverter;
	
	@Override
	public UserDTO toDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPassword(entity.getPassword());
		dto.setCompany(empresaConverter.toDTO(entity.getCompany()));
		return dto;
	}

	@Override
	public User toEntity(UserDTO dto) {
		User pessoa = new User();
		pessoa.setEmail(dto.getEmail());
		pessoa.setName(dto.getName());
		pessoa.setPassword(dto.getPassword());
		pessoa.setCompany(empresaConverter.toEntity(dto.getCompany()));
		return pessoa;
	}

}
