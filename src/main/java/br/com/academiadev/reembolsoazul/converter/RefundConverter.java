package br.com.academiadev.reembolsoazul.converter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.repository.UserRepository;
import br.com.academiadev.reembolsoazul.util.Util;

@Component
public class RefundConverter implements Converter<Refund, RefundDTO> {

	@Autowired
	private RefundCategoryConverter refundCategoryConverter;
	@Autowired
	private UserRepository user;
	
	@Override
	public RefundDTO toDTO(Refund entity) {
		RefundDTO dto = new RefundDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(entity.getCategory().getId());
		dto.setStatus(entity.getStatus().getId());
		dto.setUserName(entity.getUser().getName());
		dto.setValue(entity.getValue().toString());
		dto.setDate(Util.dateToString(entity.getDate())); 
		return dto;
	}

	@Override
	public Refund toEntity(RefundDTO dto) throws ClassNotFoundException {
		Refund entity = new Refund();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCategory(refundCategoryConverter.idtoEntity(dto.getCategory()));
		entity.setStatusById(dto.getStatus());
		entity.setDate(Util.stringToDate(dto.getDate()));
		entity.setValue(new BigDecimal(dto.getValue()));
		entity.setUser(user.findByEmail(dto.getUserName()));
		return entity;
	}

}
