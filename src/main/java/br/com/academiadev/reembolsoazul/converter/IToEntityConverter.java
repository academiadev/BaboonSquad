package br.com.academiadev.reembolsoazul.converter;

public interface IToEntityConverter<TSource, TResult> {
	public TResult toEntity(TSource dto)  ;
}
