package br.com.academiadev.reembolsoazul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.reembolsoazul.dto.RedefinePasswordDTO;
import br.com.academiadev.reembolsoazul.service.RedefinePasswordService;

@RestController
@RequestMapping("/password")
public class RedefineController {

	@Autowired
	private RedefinePasswordService redefinePasswordService;
	
	@PostMapping(value = "/request")
	public void redefinePassword(@RequestBody RedefinePasswordDTO redefinePasswordDTO) {
		redefinePasswordService.redefinePassword(redefinePasswordDTO);
	}
	
	@GetMapping("/new/{code}")
	public void viewUrl(@PathVariable Long code) {
		redefinePasswordService.alterUsed(code);
	}
}
