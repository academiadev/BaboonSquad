package br.com.academiadev.reembolsoazul.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.ListIdDTO;
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
public class RefundController extends UploadController {

	@Autowired
	private RefundService refundService;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "Cadastra um reembolso")
	@ApiResponses(value = { //
			@ApiResponse(code = 201, message = "Reembolso cadastrado com sucesso") })
	@PostMapping(value = "/")
	public ResponseEntity<RefundDTO> PostReembolso(@RequestBody RefundDTO refundDto) throws ClassNotFoundException {
		return new ResponseEntity<>(refundService.postRefund(refundDto), HttpStatus.CREATED);
	}
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "Listar reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Lista de reembolsos") })
	@GetMapping("/listaReembolsosCategoria/{userId}")
	public ResponseEntity<Map<String, List<RefundExpenseDTO>>> getAllRefundsExpenseByUser(@PathVariable Long userId) {
		return new ResponseEntity<>(refundService.getAllRefundsExpenseByUser(userId), HttpStatus.OK);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "Listar reembolsos por usuários")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Lista de reembolsos por usuários")
	})
	@GetMapping("/usuario/{userId}")
	public ResponseEntity<List<RefundDTO>> getAllRefundsByUser(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(refundService.getAllRefundsByUser(userId), HttpStatus.OK);
	}
	
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "Listar reembolsos pela empresa")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Lista de reembolsos pela empresa")
	})
	@GetMapping("/empresa/{companyCode}")
	public ResponseEntity<List<RefundDTO>> getAllRefundsByCompany(@PathVariable("companyCode") Integer companyCode) {
		return new ResponseEntity<>(refundService.getAllRefundsByCompany(companyCode), HttpStatus.OK);
	}

	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Listar reembolsos visíveis para o usuário")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Lista de reembolsos visíveis para o usuários")
	})
	@GetMapping("/usuario/{userId}/visible")
	public ResponseEntity<List<RefundDTO>> getAllRefundsVisibleByUser(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(refundService.getAllRefundsVisibleByUser(userId), HttpStatus.OK);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Atualiza um reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Reembolsos atualizado") })
	@PutMapping("/edit/{id}")
	public ResponseEntity<RefundDTO> putRefund(@RequestBody RefundDTO refundDto) throws ClassNotFoundException {
		return new ResponseEntity<>(refundService.putRefund(refundDto), HttpStatus.OK);
	}

	@ApiImplicitParams({

		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Aceita uma lista de reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Reembolsos aceitos") 
	})
	@PutMapping("/changeStatus/approved")
	public ResponseEntity<RefundDTO> putRefundChangeStatusToApproved(@RequestBody List<ListIdDTO> listIdDTO) throws ClassNotFoundException {
		refundService.putRefundChangeStatus(listIdDTO, 0);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Rejeita uma lista de reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Reembolsos rejeitados") 
	})
	@PutMapping("/changeStatus/rejected")
	public ResponseEntity<RefundDTO> putRefundChangeStatusToRejected(@RequestBody List<ListIdDTO> listIdDTO) throws ClassNotFoundException {
		refundService.putRefundChangeStatus(listIdDTO, 1);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name="Authorization", value="Authorization token", required = true, dataType= "string", paramType = "header")
	})
	@ApiOperation(value = "Deleta uma lista de reembolsos")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Reembolsos deletados") 
	})
	@DeleteMapping("/delete")
	public ResponseEntity<RefundDTO> deleteRefund(@RequestBody List<ListIdDTO> listIdDTO){
		refundService.deleteRefunds(listIdDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
