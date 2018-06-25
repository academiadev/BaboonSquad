package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.RefundSpentUserDTO;
import br.com.academiadev.reembolsoazul.model.Refund;

@Component
public class RefundSpentUserConverter  implements  IToDTOConverter<Refund, RefundSpentUserDTO>{
 
	@Override
	public RefundSpentUserDTO toDTO(Refund entity) {
		RefundSpentUserDTO dto = new RefundSpentUserDTO();
		dto.setEmail(entity.getUser().getEmail());
		dto.setUserName(entity.getUser().getName());
		dto.setValue(entity.getValue().toString());
		return dto;
	}
}
