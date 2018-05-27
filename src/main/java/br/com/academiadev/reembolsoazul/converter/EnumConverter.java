package br.com.academiadev.reembolsoazul.converter;

public interface EnumConverter <E, I, S> {
	
	public I entityToId(E entity);
	
	public S entityToDescription(E entity);
	
	public S idToDescription(I id);
	
	public E idtoEntity(I id);
	
	public I descriptionToEntity(S desc);
	
	public S descriptionToId(S desc);

}
