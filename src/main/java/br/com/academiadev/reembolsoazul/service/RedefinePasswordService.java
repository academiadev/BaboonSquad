package br.com.academiadev.reembolsoazul.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.config.StructureEmail;
import br.com.academiadev.reembolsoazul.dto.PasswordResetDTO;
import br.com.academiadev.reembolsoazul.dto.RedefinePasswordDTO;
import br.com.academiadev.reembolsoazul.model.RedefinePassword;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.repository.RedefinePasswordRepository;

@Service
public class RedefinePasswordService {

	@Autowired
	private UserService userService;

	@Autowired
	private RedefinePasswordRepository redefinePasswordRepository;

	@Autowired
	private EmailService emailService;
	
	public void requestRedefinePassword(RedefinePasswordDTO redefinePasswordDTO) {
		User user = new User();
		user = userService.findByEmail(redefinePasswordDTO.getEmail());
		if (user != null) {
			RedefinePassword redefinePassword = new RedefinePassword();
			Random random = new Random();
			redefinePassword.setUser(user);
			redefinePassword.setUsed(false);
			redefinePassword.setCode(Long.valueOf(random.nextInt(99999)));
			redefinePasswordRepository.save(redefinePassword);
			StructureEmail structureEmail = new StructureEmail();
			structureEmail.setRecipient(redefinePasswordDTO.getEmail());
			structureEmail.setBody("Acesse o link http://localhost:8080/#/password/novasenha/" + redefinePassword.getCode() + " para redefinir sua senha");
			structureEmail.setSubject("Redefinição de senha Reembolso Azul");
			emailService.sendMail(structureEmail);
		}
	}
	
	public void alterUsed(Long code) {
		RedefinePassword redefinePassword = new RedefinePassword();
		redefinePassword = redefinePasswordRepository.findByCode(code);
		redefinePassword.setUsed(true);
		redefinePasswordRepository.save(redefinePassword);
	}
	
	public void checkRedefinePassword(Long code) {
		if(redefinePasswordRepository.findByCode(code)!=null)
			alterUsed(code);
		}

	public void redefinePassword(PasswordResetDTO passwordResetDTO) {
		User user = new User();
		user = userService.findByCodeRedefinePassword(passwordResetDTO.getCode());
		user.setPassword(userService.encode(passwordResetDTO.getNewPassword()));
		userService.alterUser(user);
	
	}

}
