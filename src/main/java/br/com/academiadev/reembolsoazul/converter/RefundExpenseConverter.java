package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.RefundExpenseDTO;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.util.Util;

@Component
public class RefundExpenseConverter implements  IToDTOConverter<Refund, RefundExpenseDTO>  {
	
	@Override
	public RefundExpenseDTO toDTO(Refund entity) {
		RefundExpenseDTO dto = new RefundExpenseDTO();
		dto.setValue(entity.getValue().toString());
		dto.setDate(Util.dateToString(entity.getDate()).replace('/', '-'));
		return dto;
	}

}
