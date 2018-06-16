package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.UserConverter;
import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.exception.EmailCadastraExcption;
import br.com.academiadev.reembolsoazul.model.Authority;
import br.com.academiadev.reembolsoazul.model.PermissionType;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityService authorityService;

	public void cadastrar(UserDTO userDTO) {
		User user = userConverter.toEntity(userDTO);
		if(userRepository.findByEmail(user.getEmail())!=null) 
			throw new EmailCadastraExcption();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAuthorization(getAutorizacao(userDTO.getTypePermission()));
		if(userDTO.getTypePermission() == PermissionType.ADMIN.getId()) {
			companyService.saveCompany(user);
		}else {
			setarEmpresa(user);
		}
		userRepository.save(user);
	}

	private List<Authority> getAutorizacao(Integer id) {
		List<Authority> authorityList = new ArrayList<>();
		Authority authority = authorityService.findById(Long.valueOf(id));
		if (authority.getNome().equals(PermissionType.ADMIN.getDescription())) {
			authorityList.add(new Authority(Long.valueOf(PermissionType.USER.getId()) ,PermissionType.USER.getDescription()));
		}
		authorityList.add(authority);
		return authorityList;
	}

	private User setarEmpresa(User user) {
		user.setCompany(companyService.findByCode(user.getCompany().getCode()));
		return user;
	}
	
	
}
