package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.UserConverter;
import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.exception.EmailCadastraExecption;
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
			throw new EmailCadastraExecption();
		user.setPassword(encode(userDTO.getPassword()));
		user.setAuthorization(definedAutorizacao(userDTO.getTypePermission()));
		if(userDTO.getTypePermission() == PermissionType.ADMIN.getId()) {
			companyService.saveCompany(user);
		}else {
			setarEmpresa(user);
		}
		userRepository.save(user);
	}

	private List<Authority> definedAutorizacao(Integer id) {
		List<Authority> autorizacoes = new ArrayList<>();
		Authority autorizacao = authorityService.findById(Long.valueOf(id));
		if (autorizacao.getNome().equals(PermissionType.ADMIN.getDescription())) {
			autorizacoes.add(new Authority(Long.valueOf(PermissionType.USER.getId()) ,PermissionType.USER.getDescription()));
		}
		autorizacoes.add(autorizacao);
		return autorizacoes;
	}

	private User setarEmpresa(User user) {
		user.setCompany(companyService.findByCode(user.getCompany().getCode()));
		return user;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByCodeRedefinePassword(Long code) {
		return userRepository.findByRedefinePassword_code(code);
	}
	
	public User alterUser(User user) {
		return userRepository.save(user);
	}
	
	public String encode(String password) {
		return passwordEncoder.encode(password);
	}
	
	public User GetUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
}
