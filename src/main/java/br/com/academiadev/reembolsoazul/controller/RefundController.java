package br.com.academiadev.reembolsoazul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.RefundDTO;
import br.com.academiadev.reembolsoazul.dto.RefundExpenseDTO;
import br.com.academiadev.reembolsoazul.service.RefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Reembolso")
@RestController
@RequestMapping("/reembolso")
public class RefundController {

	@Autowired
	private RefundService reembolsoService;

	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Cadastra um reembolso")
	@ApiResponses(value = { //
			@ApiResponse(code = 201, message = "Empresa cadastrada com sucesso") //
	})
	@PostMapping(value = "/")
	public ResponseEntity<RefundDTO> PostReembolso(@RequestBody RefundDTO reembolsoDto) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Listar reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Lista de reembolsos") //
	})
	@GetMapping("/listaReembolsosCategoria")
	public List<RefundExpenseDTO> listaReembolsosCategoria() {
		List<RefundExpenseDTO> listReembolsoDTO = reembolsoService.GetAllReembolso();
		return listReembolsoDTO;
	}
}
