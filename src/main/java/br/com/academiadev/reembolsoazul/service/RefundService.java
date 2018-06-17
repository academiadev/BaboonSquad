package br.com.academiadev.reembolsoazul.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.RefundConverter;
import br.com.academiadev.reembolsoazul.converter.RefundExpenseConverter;
import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.dto.RefundExpenseDTO;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.repository.RefundRepository;

@Service
public class RefundService {

	@Autowired
	private RefundConverter refundConverter;
	@Autowired
	private RefundExpenseConverter refundExpenseConverter;

	@Autowired
	private RefundRepository refundRepository;

	public void PostReembolso(RefundDTO refundDto) {
		Refund refund = new Refund();
		refund = refundConverter.toEntity(refundDto);
		refundRepository.save(refund);
	}

	public RefundDTO GetReembolsoById(Long id) {
		RefundDTO refundDto = new RefundDTO();
		refundDto = refundConverter.toDTO(refundRepository.findOne(id));
		return refundDto;
	}

	public List<RefundExpenseDTO> GetAllReembolso() {
		//List<Refund> refund = (List<Refund>) refundRepository.findAllOrderBydate();
		List<Refund> refund = (List<Refund>) refundRepository.findAll();
		List<RefundExpenseDTO> dtos = refund.stream().map(refundExpenseConverter::toDTO).collect(Collectors.toList());
		return dtos;
	}

}
