package br.com.academiadev.reembolsoazul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.PasswordResetDTO;
import br.com.academiadev.reembolsoazul.dto.RedefinePasswordDTO;
import br.com.academiadev.reembolsoazul.service.RedefinePasswordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/password")
public class RedefineController {

	@Autowired
	private RedefinePasswordService redefinePasswordService;
	
	@PostMapping(value = "/request")
	public void redefinePassword(@RequestBody RedefinePasswordDTO redefinePasswordDTO) {
		redefinePasswordService.requestRedefinePassword(redefinePasswordDTO);
	}
	
	@ApiOperation(value = "Verificação visualização")
	@ApiResponses(value = { //
			@ApiResponse(code = 200, message = "Primeira visualização"), //
			@ApiResponse(code = 401, message = "Já visualizou"), //
	})
	@GetMapping("/new/{code}")
	public ResponseEntity<?> viewUrl(@RequestBody @PathVariable Long code) {
		return ResponseEntity.ok(redefinePasswordService.checkRedefinePassword(code));
	}
	
	@PostMapping(value = "/alter")
	public void alterPassword(@RequestBody PasswordResetDTO passwordResetDTO) {
		redefinePasswordService.redefinePassword(passwordResetDTO);
	}
}
