package br.com.academiadev.reembolsoazul.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.ReembolsoDto;
import br.com.academiadev.reembolsoazul.model.Reembolso;

@Component
public class ReembolsoConverter implements Converter<Reembolso, ReembolsoDto> {

	@Override
	public ReembolsoDto toDTO(Reembolso entity) {
		ReembolsoDto dto = new ReembolsoDto();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCategoria(entity.getCategoria().getDescricao());
		dto.setStatus(entity.getStatus().getDescricao());;
		return dto;
	}

	@Override
	public Reembolso toEntity(ReembolsoDto dto) {
		Reembolso entity = new Reembolso();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		//entity.setCategoria(dto.getCategoria());;
		return entity;
	}
	
	

}
