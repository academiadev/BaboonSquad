package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.model.Refund;

@Component
public class RefundConverter implements Converter<Refund, RefundDTO> {

	@Override
	public RefundDTO toDTO(Refund entity) {
		RefundDTO dto = new RefundDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(entity.getCategory().getDescricao());
		dto.setStatus(entity.getStatus().getDescricao());
		dto.setUserName(entity.getUser().getName());
		dto.setEmail(entity.getUser().getEmail());
		dto.setValue(entity.getValue().toString());
		return dto;
	}

	@Override
	public Refund toEntity(RefundDTO dto) {
		Refund entity = new Refund();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		// entity.setCategoria(dto.getCategoria());;
		return entity;
	}

}
