package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
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

	public RefundDTO postRefund(RefundDTO refundDto) throws ClassNotFoundException {
		Refund refund = new Refund();
		refund = refundConverter.toEntity(refundDto);
		refundRepository.save(refund);
		return refundDto;
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
	
	public RefundDTO putRefund(RefundDTO refundDto) throws ClassNotFoundException {
		Refund refund = refundConverter.toEntity(refundDto);
		refundRepository.save(refund);  
		return refundDto;
	}
	
	public void deleteRefund(Long refundId) {
		refundRepository.delete(refundId); 
		return;
	}
	
	public List<RefundDTO> getAllRefundsByUser(Long userId) {
		List<Refund> refundList = refundRepository.findByUser_Id(userId);
		List<RefundDTO> refundDTOList = new ArrayList<>();
		for (Refund refund : refundList) {
			refundDTOList.add(refundConverter.toDTO(refund));
		}

		return refundDTOList;
	}
	
}
