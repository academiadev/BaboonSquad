package com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academiadev.reembolsoazul.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{
	public Empresa findByCodigo(Integer codigoEmpresa);
}
