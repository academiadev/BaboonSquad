package com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academiadev.reembolsoazul.model.Reembolso;

@Repository
public interface ReembolsoRepository extends CrudRepository<Reembolso, Long> {

}
