package br.com.academiadev.reembolsoazul.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.model.User;

@Component
public class UserConverter implements Converter<User, UserDTO>{

	@Autowired
	private CompanyConverter companyConverter;
	
	@Override
	public UserDTO toDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPassword(entity.getPassword());
		dto.setCompany(companyConverter.toDTO(entity.getCompany()));
		return dto;
	}

	@Override
	public User toEntity(UserDTO userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setCompany(companyConverter.toEntity(userDto.getCompany()));
		return user;
	}

}
