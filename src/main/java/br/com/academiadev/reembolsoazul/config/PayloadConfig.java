package br.com.academiadev.reembolsoazul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.model.Authority;
import br.com.academiadev.reembolsoazul.repository.AuthorityRepository;

@Component
public class PayloadConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AuthorityRepository authorityRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		payloadAuthority();
		
		 
		
	}

	private void payloadAuthority() {
		Authority admin = new Authority(1l, "ROLE_ADMIN");
		Authority user = new Authority(2l, "ROLE_USER");
		
		authorityRepository.save(admin);
		authorityRepository.save(user);
	}
	
}
