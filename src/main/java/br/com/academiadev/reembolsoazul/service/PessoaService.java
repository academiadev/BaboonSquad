package br.com.academiadev.reembolsoazul.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academiadev.reembolsoazul.converter.PessoaConverter;
import br.com.academiadev.reembolsoazul.dto.PessoaDTO;
import br.com.academiadev.reembolsoazul.exception.EmailCadastraExcption;
import br.com.academiadev.reembolsoazul.model.Autorizacao;
import br.com.academiadev.reembolsoazul.model.Empresa;
import br.com.academiadev.reembolsoazul.model.Pessoa;
import br.com.academiadev.reembolsoazul.model.TipoPermissao;
import br.com.academiadev.reembolsoazul.repository.AutorizacaoRepository;
import br.com.academiadev.reembolsoazul.repository.EmpresaRepository;
import br.com.academiadev.reembolsoazul.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaConverter pessoaConverter;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private AutorizacaoRepository autorizacaoRepository;

	public void cadastrar(PessoaDTO pessoaDto) {
		Pessoa pessoa = pessoaConverter.toEntity(pessoaDto);
		if(pessoaRepository.findByEmail(pessoa.getEmail())!=null) 
			throw new EmailCadastraExcption();
		pessoa.setSenha(passwordEncoder.encode(pessoa.getPassword()));
		pessoa.setAutorizacoes(getAutorizacao(pessoaDto.getTypePermission()));
		if(pessoaDto.getTypePermission() == TipoPermissao.ADMIN.getId()) {
			gravaEmpresa(pessoa);
		}else {
			setarEmpresa(pessoa);
		}
		pessoaRepository.save(pessoa);
	}

	private List<Autorizacao> getAutorizacao(Integer id) {
		List<Autorizacao> autorizacoes = new ArrayList<>();
		Autorizacao autorizacao = autorizacaoRepository.findOne(Long.valueOf(id));
		if (autorizacao.getNome().equals(TipoPermissao.ADMIN.getDescricao())) {
			autorizacoes.add(new Autorizacao(Long.valueOf(TipoPermissao.USER.getId()) ,TipoPermissao.USER.getDescricao()));
		}
		autorizacoes.add(autorizacao);
		return autorizacoes;
	}

	private Pessoa setarEmpresa(Pessoa pessoa) {
		pessoa.setEmpresa(empresaRepository.findByCodigo(pessoa.getEmpresa().getCodigo()));
		return pessoa;
	}
	
	private void gravaEmpresa(Pessoa pessoa) {
		Empresa empresa = pessoa.getEmpresa();
		do {
			Random random = new Random();
			empresa.setCodigo(random.nextInt(99999));
		} while (empresaRepository.existsByCodigo(empresa.getCodigo()));
		empresaRepository.save(empresa);
	}
}
