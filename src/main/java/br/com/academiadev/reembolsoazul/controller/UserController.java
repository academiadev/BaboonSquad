package br.com.academiadev.reembolsoazul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.config.jwt.TokenHelper;
import br.com.academiadev.reembolsoazul.dto.TokenDTO;
import br.com.academiadev.reembolsoazul.dto.UserAlterDTO;
import br.com.academiadev.reembolsoazul.dto.UserDTO;
import br.com.academiadev.reembolsoazul.exception.CompanyExecption;
import br.com.academiadev.reembolsoazul.exception.EmailExecption;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.service.UserService;

@RestController
@RequestMapping("/pessoa")
public class UserController {
	
	@Autowired
	public UserService userService;

	@Autowired
	private TokenHelper tokenHelper;
	
	@PostMapping(value = "/gravar")
	public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws EmailExecption, CompanyExecption {
		userService.register(userDTO);
		return ResponseEntity.ok(userDTO);
	}
	
	@PostMapping(value ="/alterar")
	public ResponseEntity<?> alterRegister(@RequestBody UserAlterDTO userAlterDTO, Device dispositivo ) {
		userService.alterRegister(userAlterDTO);
		User user = userService.getUserByEmail(userAlterDTO.getNewEmail());
		String token = tokenHelper.gerarToken(user, dispositivo);
		int expiresIn = tokenHelper.getExpiredIn(dispositivo);
		return ResponseEntity.ok(new TokenDTO(token, Long.valueOf(expiresIn)));
	}
	
	
}
