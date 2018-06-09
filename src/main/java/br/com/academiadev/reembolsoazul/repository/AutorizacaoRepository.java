package br.com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.reembolsoazul.model.Autorizacao;

@Repository
public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {

	public Autorizacao findByNome(String nome);

}
