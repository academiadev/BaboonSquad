package br.com.academiadev.reembolsoazul.converter;

public interface IToDTOConverter <TSource, TResult> {
	public TResult toDTO(TSource entity);
}
