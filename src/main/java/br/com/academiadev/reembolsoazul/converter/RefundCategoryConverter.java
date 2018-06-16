package br.com.academiadev.reembolsoazul.converter;

import br.com.academiadev.reembolsoazul.model.RefundCategory;

public class RefundCategoryConverter implements EnumConverter <RefundCategory, Integer, String> {

	@Override
	public Integer entityToId(RefundCategory entity) {
		return entity.getId();
	}

	@Override
	public String entityToDescription(RefundCategory entity) {
		return entity.getDescricao();
	}

	@Override
	public String idToDescription(Integer id) throws ClassNotFoundException {
		if(id == RefundCategory.OUTROS.getId()) {
			return RefundCategory.OUTROS.getDescricao();
		}else if (id == RefundCategory.HOSPEDAGEM.getId()) {
			return RefundCategory.HOSPEDAGEM.getDescricao();
		}else if (id == RefundCategory.TRANSPORTE.getId()) {
			return RefundCategory.TRANSPORTE.getDescricao();
		}else if (id == RefundCategory.ALIMENTACAO.getId()) {
			return RefundCategory.ALIMENTACAO.getDescricao();
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}
	}

	@Override
	public RefundCategory idtoEntity(Integer id) throws ClassNotFoundException {
		if(id == RefundCategory.OUTROS.getId()) {
			return RefundCategory.OUTROS;
		}else if (id == RefundCategory.HOSPEDAGEM.getId()) {
			return RefundCategory.HOSPEDAGEM;
		}else if (id == RefundCategory.TRANSPORTE.getId()) {
			return RefundCategory.TRANSPORTE;
		}else if (id == RefundCategory.ALIMENTACAO.getId()) {
			return RefundCategory.ALIMENTACAO;
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}
	}

	@Override
	public Integer descriptionToEntity(String desc) throws ClassNotFoundException {
		if(desc == RefundCategory.OUTROS.getDescricao()) {
			return RefundCategory.OUTROS.getId();
		}else if (desc == RefundCategory.HOSPEDAGEM.getDescricao()) {
			return RefundCategory.HOSPEDAGEM.getId();
		}else if (desc == RefundCategory.TRANSPORTE.getDescricao()) {
			return RefundCategory.TRANSPORTE.getId();
		}else if (desc == RefundCategory.ALIMENTACAO.getDescricao()) {
			return RefundCategory.ALIMENTACAO.getId();
		} else {
		throw new ClassNotFoundException("Id inválido para Categoria de Reembolso");
		}	
	}

	@Override
	public String descriptionToId(String desc) throws ClassNotFoundException {
		if(desc == RefundCategory.OUTROS.getDescricao()) {
			return RefundCategory.OUTROS.getDescricao();
		}else if (desc == RefundCategory.HOSPEDAGEM.getDescricao()) {
			return RefundCategory.HOSPEDAGEM.getDescricao();
		}else if (desc == RefundCategory.TRANSPORTE.getDescricao()) {
			return RefundCategory.TRANSPORTE.getDescricao();
		}else if (desc == RefundCategory.ALIMENTACAO.getDescricao()) {
			return RefundCategory.ALIMENTACAO.getDescricao();
		} else {
		throw new ClassNotFoundException("Descrição inválida para Categoria de Reembolso");
		}
	}

}
