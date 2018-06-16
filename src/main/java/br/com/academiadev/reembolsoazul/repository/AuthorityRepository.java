package br.com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.reembolsoazul.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

	public Authority findByName(String name);

}
