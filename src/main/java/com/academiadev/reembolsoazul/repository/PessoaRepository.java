package com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academiadev.reembolsoazul.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
