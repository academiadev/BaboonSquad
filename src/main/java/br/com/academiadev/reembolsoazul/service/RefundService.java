package br.com.academiadev.reembolsoazul.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.RefundConverter;
import br.com.academiadev.reembolsoazul.converter.RefundExpenseConverter;
import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.dto.RefundExpenseDTO;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.model.RefundCategory;
import br.com.academiadev.reembolsoazul.repository.RefundRepository;

@Service
public class RefundService {

	@Autowired
	private RefundConverter refundConverter;
	@Autowired
	private RefundExpenseConverter refundExpenseConverter;

	@Autowired
	private RefundRepository refundRepository;

	public void postReembolso(RefundDTO refundDto) {
		Refund refund = new Refund();
		refund = refundConverter.toEntity(refundDto);
		refundRepository.save(refund);
	}

	public RefundDTO getReembolsoById(Long id) {
		RefundDTO refundDto = new RefundDTO();
		refundDto = refundConverter.toDTO(refundRepository.findOne(id));
		return refundDto;
	}

	public Map<String, List<RefundExpenseDTO>> getAllReembolso() {
		List<Refund> refunds = (List<Refund>) refundRepository.findAllByOrderByDateAsc();
		return this.agroupingRefunds(refunds);
	}

	private Map<String, List<RefundExpenseDTO>> agroupingRefunds(List<Refund> refunds){
		Map<String, List<RefundExpenseDTO>> grouping = new HashMap<>();
		
		for (RefundCategory cat  : RefundCategory.values()){
			List<RefundExpenseDTO> grouped  = refunds.stream()
					.filter(f -> f.getCategory().equals(cat))
					.map(refundExpenseConverter::toDTO)
					.collect(Collectors.toList());
			grouping.put(cat.getDescricao(), grouped);
		}
		
		return grouping;
	}
}
