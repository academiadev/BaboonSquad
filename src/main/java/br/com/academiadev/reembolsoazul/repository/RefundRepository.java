package br.com.academiadev.reembolsoazul.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.model.RefundStatus;

@Repository
public interface RefundRepository extends CrudRepository<Refund, Long> {
	
	public List<Refund> findByUser_Id(Long user_id);
	
	public List<Refund> findByStatusAndUser_Id(RefundStatus status, Long user_id);
	
	public List<Refund> findByStatusAndUser_Company_code(RefundStatus status, Integer code);
	
}