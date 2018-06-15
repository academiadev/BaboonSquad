package br.com.academiadev.reembolsoazul.converter;

import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.dto.ReembolsoDTO;
import br.com.academiadev.reembolsoazul.model.Reembolso;

@Component
public class ReembolsoConverter implements Converter<Reembolso, ReembolsoDTO> {

	@Override
	public ReembolsoDTO toDTO(Reembolso entity) {
		ReembolsoDTO dto = new ReembolsoDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setCategoria(entity.getCategoria().getDescricao());
		dto.setStatus(entity.getStatus().getDescricao());
		dto.setPessoaNome(entity.getUsuario().getName());
		dto.setEmail(entity.getUsuario().getEmail());
		dto.setValor(entity.getValor().toString());
		return dto;
	}

	@Override
	public Reembolso toEntity(ReembolsoDTO dto) {
		Reembolso entity = new Reembolso();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		// entity.setCategoria(dto.getCategoria());;
		return entity;
	}

}
