package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.UserConverter;
import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.exception.EmailCadastraExcption;
import br.com.academiadev.reembolsoazul.model.Autorizacao;
import br.com.academiadev.reembolsoazul.model.TipoPermissao;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserConverter pessoaConverter;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AutorizacaoService autorizacaoService;

	public void cadastrar(UserDTO userDTO) {
		User pessoa = pessoaConverter.toEntity(userDTO);
		if(userRepository.findByEmail(pessoa.getEmail())!=null) 
			throw new EmailCadastraExcption();
		pessoa.setPassword(passwordEncoder.encode(pessoa.getPassword()));
		pessoa.setAuthorization(getAutorizacao(userDTO.getTypePermission()));
		if(userDTO.getTypePermission() == TipoPermissao.ADMIN.getId()) {
			companyService.saveCompany(pessoa);
		}else {
			setarEmpresa(pessoa);
		}
		userRepository.save(pessoa);
	}

	private List<Autorizacao> getAutorizacao(Integer id) {
		List<Autorizacao> autorizacoes = new ArrayList<>();
		Autorizacao autorizacao = autorizacaoService.findById(Long.valueOf(id));
		if (autorizacao.getNome().equals(TipoPermissao.ADMIN.getDescricao())) {
			autorizacoes.add(new Autorizacao(Long.valueOf(TipoPermissao.USER.getId()) ,TipoPermissao.USER.getDescricao()));
		}
		autorizacoes.add(autorizacao);
		return autorizacoes;
	}

	private User setarEmpresa(User pessoa) {
		pessoa.setCompany(companyService.findByCodigo(pessoa.getCompany().getCode()));
		return pessoa;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
	
}
