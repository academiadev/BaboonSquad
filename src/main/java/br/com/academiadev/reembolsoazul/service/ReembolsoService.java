package br.com.academiadev.reembolsoazul.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.ReembolsoConverter;
import br.com.academiadev.reembolsoazul.dto.ReembolsoDTO;
import br.com.academiadev.reembolsoazul.model.Reembolso;
import br.com.academiadev.reembolsoazul.repository.ReembolsoRepository;

@Service
public class ReembolsoService {

	@Autowired
	private ReembolsoConverter reembolsoConverter;

	@Autowired
	private ReembolsoRepository reembolsoRepository;

	public void PostReembolso(ReembolsoDTO reembolsoDto) {
		Reembolso reembolso = new Reembolso();
		reembolso = reembolsoConverter.toEntity(reembolsoDto);
		reembolsoRepository.save(reembolso);
	}

	public ReembolsoDTO GetReembolsoById(Long id) {
		ReembolsoDTO reembolsoDto = new ReembolsoDTO();
		reembolsoDto = reembolsoConverter.toDTO(reembolsoRepository.findOne(id));
		return reembolsoDto;
	}

	public List<ReembolsoDTO> GetAllReembolso() {
		List<Reembolso> reembolsos = (List<Reembolso>) reembolsoRepository.findAll();
		List<ReembolsoDTO> dtos = reembolsos.stream().map(reembolsoConverter::toDTO).collect(Collectors.toList());
		return dtos;
	}

}
