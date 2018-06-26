package br.com.academiadev.reembolsoazul.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.academiadev.reembolsoazul.model.Authority;
import br.com.academiadev.reembolsoazul.model.Company;
import br.com.academiadev.reembolsoazul.model.Refund;
import br.com.academiadev.reembolsoazul.model.RefundCategory;
import br.com.academiadev.reembolsoazul.model.RefundStatus;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.repository.AuthorityRepository;
import br.com.academiadev.reembolsoazul.repository.CompanyRepository;
import br.com.academiadev.reembolsoazul.repository.RefundRepository;
import br.com.academiadev.reembolsoazul.repository.UserRepository;

@Component
public class PayloadConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AuthorityRepository authorityRepository;
	@Autowired
	RefundRepository refundRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		payloadAuthority();
		Company company = payloadCompany();
		User user = payloadUser(company);
		payloadRefunds(user);
	}

	private void payloadAuthority() {
		Authority admin = new Authority(1l, "ROLE_ADMIN");
		Authority user = new Authority(2l, "ROLE_USER");

		authorityRepository.save(admin);
		authorityRepository.save(user);
	}

	private Company payloadCompany() {
		Company company = new Company();
		company.setId(1l);
		company.setName("Empresa do marcelo");
		company.setCode(1);

		return companyRepository.save(company);
	}

	private User payloadUser(Company company) {
		User user = new User();
		user.setId(1l);
		user.setName("Marcelo");
		user.setEmail("mc@gmail.com");
		user.setCompany(company);
		user.setPassword("$2a$10$NcBiKEGGXD.L7J1EZy.mvOypnf8op4kQAZSyJLZ8/0eRal4cIFc2u");
		
		return userRepository.save(user);
	}

	private void payloadRefunds(User user) {
		for (Long i = 0l; i < 100l; i++) {
			Refund refund = new Refund();
			refund.setCategory(RefundCategory.ALIMENTACAO);
			refund.setName("Lanchonete do centro " + i);
			refund.setStatus(RefundStatus.APROVADO);
			refund.setShowForUser(true);
			refund.setValue(PayloadConfig.generateRandomBigDecimalFromRange(BigDecimal.ZERO, new BigDecimal(20)));
			refund.setDate(PayloadConfig.generateRandomDateFromYear(2017));
			refund.setUser(user);
		
			refundRepository.save(refund);
		}
		
		for (Long i = 100l; i < 200l; i++) {
			Refund refund = new Refund();
			refund.setCategory(RefundCategory.HOSPEDAGEM);
			refund.setName("Hotel Ibis " + i);
			refund.setShowForUser(true);
			refund.setStatus(RefundStatus.APROVADO);
			refund.setValue(PayloadConfig.generateRandomBigDecimalFromRange(BigDecimal.ZERO, new BigDecimal(20)));
			refund.setDate(PayloadConfig.generateRandomDateFromYear(2017));
			refund.setUser(user);
			
			refundRepository.save(refund);
		}
		
		for (Long i = 200l; i < 300l; i++) {
			Refund refund = new Refund();
			refund.setId(i);
			refund.setCategory(RefundCategory.TRANSPORTE);
			refund.setName("Uber na viagem " + i);
			refund.setShowForUser(true);
			refund.setStatus(RefundStatus.APROVADO);
			refund.setValue(PayloadConfig.generateRandomBigDecimalFromRange(BigDecimal.ZERO, new BigDecimal(20)));
			refund.setDate(PayloadConfig.generateRandomDateFromYear(2017));
			refund.setUser(user);
			
			refundRepository.save(refund);
		}
	}
	
	private static BigDecimal generateRandomBigDecimalFromRange(BigDecimal min, BigDecimal max) {
	    BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
	    return randomBigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	
	private static LocalDate generateRandomDateFromYear(int year) {
		Random random = new Random();
		int minDay = (int) LocalDate.of(year, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(year, 12, 31).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		return LocalDate.ofEpochDay(randomDay);
	}
}
