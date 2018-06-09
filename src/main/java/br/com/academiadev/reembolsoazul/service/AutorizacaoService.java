package br.com.academiadev.reembolsoazul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.model.Autorizacao;
import br.com.academiadev.reembolsoazul.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {

	@Autowired
	private AutorizacaoRepository autorizacaoRepository;

	public Autorizacao findById(Long id) {
		return autorizacaoRepository.findOne(id);
	}

}
