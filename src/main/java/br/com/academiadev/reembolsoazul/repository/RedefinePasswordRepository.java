package br.com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.academiadev.reembolsoazul.model.RedefinePassword;

public interface RedefinePasswordRepository extends CrudRepository<RedefinePassword, Long>{
	
	public RedefinePassword findByCode(Long code);

}
