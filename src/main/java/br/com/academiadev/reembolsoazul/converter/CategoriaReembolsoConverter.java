package br.com.academiadev.reembolsoazul.converter;

import br.com.academiadev.reembolsoazul.model.CategoriaReembolso;

public class CategoriaReembolsoConverter implements EnumConverter <CategoriaReembolso, Integer, String> {

	@Override
	public Integer entityToId(CategoriaReembolso entity) {
		return entity.getId();
	}

	@Override
	public String entityToDescription(CategoriaReembolso entity) {
		return entity.getDescricao();
	}

	@Override
	public String idToDescription(Integer id) throws ClassNotFoundException {
		if(id == CategoriaReembolso.OUTROS.getId()) {
			return CategoriaReembolso.OUTROS.getDescricao();
		}else if (id == CategoriaReembolso.HOSPEDAGEM.getId()) {
			return CategoriaReembolso.HOSPEDAGEM.getDescricao();
		}else if (id == CategoriaReembolso.TRANSPORTE.getId()) {
			return CategoriaReembolso.TRANSPORTE.getDescricao();
		}else if (id == CategoriaReembolso.ALIMENTACAO.getId()) {
			return CategoriaReembolso.ALIMENTACAO.getDescricao();
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}
	}

	@Override
	public CategoriaReembolso idtoEntity(Integer id) throws ClassNotFoundException {
		if(id == CategoriaReembolso.OUTROS.getId()) {
			return CategoriaReembolso.OUTROS;
		}else if (id == CategoriaReembolso.HOSPEDAGEM.getId()) {
			return CategoriaReembolso.HOSPEDAGEM;
		}else if (id == CategoriaReembolso.TRANSPORTE.getId()) {
			return CategoriaReembolso.TRANSPORTE;
		}else if (id == CategoriaReembolso.ALIMENTACAO.getId()) {
			return CategoriaReembolso.ALIMENTACAO;
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}
	}

	@Override
	public Integer descriptionToEntity(String desc) throws ClassNotFoundException {
		if(desc == CategoriaReembolso.OUTROS.getDescricao()) {
			return CategoriaReembolso.OUTROS.getId();
		}else if (desc == CategoriaReembolso.HOSPEDAGEM.getDescricao()) {
			return CategoriaReembolso.HOSPEDAGEM.getId();
		}else if (desc == CategoriaReembolso.TRANSPORTE.getDescricao()) {
			return CategoriaReembolso.TRANSPORTE.getId();
		}else if (desc == CategoriaReembolso.ALIMENTACAO.getDescricao()) {
			return CategoriaReembolso.ALIMENTACAO.getId();
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}	
	}

	@Override
	public String descriptionToId(String desc) throws ClassNotFoundException {
		if(desc == CategoriaReembolso.OUTROS.getDescricao()) {
			return CategoriaReembolso.OUTROS.getDescricao();
		}else if (desc == CategoriaReembolso.HOSPEDAGEM.getDescricao()) {
			return CategoriaReembolso.HOSPEDAGEM.getDescricao();
		}else if (desc == CategoriaReembolso.TRANSPORTE.getDescricao()) {
			return CategoriaReembolso.TRANSPORTE.getDescricao();
		}else if (desc == CategoriaReembolso.ALIMENTACAO.getDescricao()) {
			return CategoriaReembolso.ALIMENTACAO.getDescricao();
		} else {
		throw new ClassNotFoundException("Descrição inválida para Categoria de Reembolso");
		}
	}

}
