package br.com.academiadev.reembolsoazul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void enviar() {
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		
		simpleMail.setFrom("reembolaso.azul.acad@gmail.com");
		simpleMail.setTo("eric.oliveira.mesquita@gmail.com");
		simpleMail.setSubject("Testa");
		simpleMail.setText("Testa");
		
		javaMailSender.send(simpleMail);
	}
}
