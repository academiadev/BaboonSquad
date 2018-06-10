package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.ReembolsoConverter;
import br.com.academiadev.reembolsoazul.dto.ReembolsoDto;
import br.com.academiadev.reembolsoazul.model.Reembolso;
import br.com.academiadev.reembolsoazul.repository.ReembolsoRepository;

@Service
public class ReembolsoService {

	@Autowired
	private ReembolsoConverter reembolsoConverter;
	
	@Autowired
	private ReembolsoRepository reembolsoRepository;
	
	public void PostReembolso(ReembolsoDto reembolsoDto) {
		Reembolso reembolso = new Reembolso();
		reembolso = reembolsoConverter.toEntity(reembolsoDto);
		reembolsoRepository.save(reembolso);
	}
	
	public ReembolsoDto GetReembolsoById(Long id) {
		ReembolsoDto reembolsoDto = new ReembolsoDto();
		reembolsoDto = reembolsoConverter.toDTO(reembolsoRepository.findOne(id));
		return reembolsoDto;
	}
	
	public List<ReembolsoDto> GetAllReembolsoOrderByDateTop10(){
		List<Reembolso> reembolsos = new ArrayList();
		return null;
	}
	
	
	
}
