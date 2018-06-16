package br.com.academiadev.reembolsoazul.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.reembolsoazul.model.Refund;

@Repository
public interface RefundRepository extends CrudRepository<Refund, Long> {
}
