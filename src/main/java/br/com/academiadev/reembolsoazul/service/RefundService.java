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
import br.com.academiadev.reembolsoazul.dto.ListIdDTO;
import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.dto.RefundExpenseDTO;
import br.com.academiadev.reembolsoazul.model.Company;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.model.RefundCategory;
import br.com.academiadev.reembolsoazul.model.RefundStatus;
import br.com.academiadev.reembolsoazul.repository.CompanyRepository;
import br.com.academiadev.reembolsoazul.repository.RefundRepository;

@Service
public class RefundService {

	@Autowired
	private RefundConverter refundConverter;
	@Autowired
	private RefundExpenseConverter refundExpenseConverter;
	@Autowired
	private CompanyRepository companyRepository;

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

	public Map<String, List<RefundExpenseDTO>> getAllRefundsExpenseByUser(Long id) {
		List<Refund> refunds = (List<Refund>) refundRepository.findByUser_Id(id);
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
	
	public void deleteRefunds(List<ListIdDTO> listIdDTO) {
		for(ListIdDTO refundIdDto : listIdDTO) {
			Refund refund = refundRepository.findOne(refundIdDto.getId());
			if(refund.getStatus() != RefundStatus.APROVADO) {
				refundRepository.delete(refundIdDto.getId());
			}else {
				refund.setShowForUser(false);
				refundRepository.save(refund);
			}
		}
	}
	
	public void putRefundChangeStatus(List<ListIdDTO> listIdDTO, Integer statusId) {
		
		for(ListIdDTO refundIdDto : listIdDTO) {
			Refund refund = refundRepository.findOne(refundIdDto.getId());
			if(refund.getStatus() != RefundStatus.APROVADO) {
				refund.setStatusById(statusId);
				refundRepository.save(refund);
			}
		}
	}
	
	public List<RefundDTO> getAllRefundsByUser(Long userId) {
		List<Refund> refundList = refundRepository.findByUser_Id(userId);
		List<RefundDTO> refundDTOList = new ArrayList<>();
		for (Refund refund : refundList) {
			refundDTOList.add(refundConverter.toDTO(refund));
		}

		return refundDTOList;
	}
	
	public List<RefundDTO> getAllRefundsByCompany(Integer companyCode) {
		Company company = companyRepository.findByCode(companyCode);
		List<Refund> refundList = refundRepository.findByUser_CompanyId(company.getId());
		List<RefundDTO> refundDTOList = new ArrayList<>();
		for (Refund refund : refundList) {
			refundDTOList.add(refundConverter.toDTO(refund));
		}

		return refundDTOList;
	}
	
	public List<RefundDTO> getAllRefundsVisibleByUser(Long userId) {
		List<Refund> refundList = refundRepository.findByUser_Id(userId);
		List<RefundDTO> refundDTOList = new ArrayList<>();
		for (Refund refund : refundList) {
			if(refund.getShowForUser()) {
				refundDTOList.add(refundConverter.toDTO(refund));
			}
		}

		return refundDTOList;
	}
	
}
