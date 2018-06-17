package br.com.academiadev.reembolsoazul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.config.StructureEmail;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(StructureEmail structureEmail) {
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		
		simpleMail.setFrom("reembolaso.azul.acad@gmail.com");
		simpleMail.setTo(structureEmail.getRecipient());
		simpleMail.setSubject(structureEmail.getSubject());
		simpleMail.setText(structureEmail.getBody());
		
		javaMailSender.send(simpleMail);
	}
}
