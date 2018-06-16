package br.com.academiadev.reembolsoazul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.model.Authority;
import br.com.academiadev.reembolsoazul.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	public Authority findById(Long id) {
		return authorityRepository.findOne(id);
	}

}
