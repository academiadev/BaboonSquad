package br.com.academiadev.reembolsoazul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.ReembolsoDto;
import br.com.academiadev.reembolsoazul.service.ReembolsoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api("Reembolso")
@RestController
@RequestMapping("/reembolso")
public class ReembolsoController {
	
	@Autowired
	private ReembolsoService reembolsoService;
	
	@ApiOperation(value = "Cadastra um reembolso")
	@ApiResponses(value = { //
			@ApiResponse(code = 201, message = "Empresa cadastrada com sucesso") //
	})
	@PostMapping(value = "/")
	public ResponseEntity<ReembolsoDto> PostReembolso(@RequestBody ReembolsoDto reembolsoDto) {
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
