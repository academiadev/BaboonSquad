package br.com.academiadev.reembolsoazul.converter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.repository.UserRepository;
import br.com.academiadev.reembolsoazul.util.Util;

@Component
public class RefundConverter implements IToEntityConverter<RefundDTO, Refund>, IToDTOConverter<Refund, RefundDTO> {

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
		dto.setShowForUser(entity.getShowForUser());
		dto.setFile(entity.getFile());
		return dto;
	}

	@Override
	public Refund toEntity(RefundDTO dto) {
		Refund entity = new Refund();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setStatusById(dto.getStatus());
		entity.setDate(Util.stringToDate(dto.getDate()));
		entity.setValue(new BigDecimal(dto.getValue()));
		entity.setUser(user.findByEmail(dto.getUserName()));
		entity.setShowForUser(dto.getShowForUser());
		entity.setFile(dto.getFile());

		try {
			entity.setCategory(refundCategoryConverter.idtoEntity(dto.getCategory()));
		} catch (ClassNotFoundException e) {
		}
		
		return entity;
	}

}
