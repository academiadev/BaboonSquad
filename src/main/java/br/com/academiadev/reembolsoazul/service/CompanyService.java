package br.com.academiadev.reembolsoazul.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.model.Company;
import br.com.academiadev.reembolsoazul.model.User;
import br.com.academiadev.reembolsoazul.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company findByCodigo(Integer codeCompany) {
		return companyRepository.findByCode(codeCompany);
	}
	
	public Boolean existsByCodigo(Integer codeCompany) {
		return companyRepository.existsByCode(codeCompany);
	}
	
	public void saveCompany(User pessoa) {
		Company empresa = pessoa.getCompany();
		do {
			Random random = new Random();
			empresa.setCode(random.nextInt(99999));
		} while (companyRepository.existsByCode(empresa.getCode()));
		companyRepository.save(empresa);
	}
}
