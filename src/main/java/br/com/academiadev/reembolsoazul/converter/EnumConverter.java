package br.com.academiadev.reembolsoazul.converter;

public interface EnumConverter <E, I, S> {
	
	public I entityToId(E entity);
	
	public S entityToDescription(E entity);
	
	public S idToDescription(I id) throws ClassNotFoundException;
	
	public E idtoEntity(I id) throws ClassNotFoundException;
	
	public I descriptionToEntity(S desc) throws ClassNotFoundException;
	
	public S descriptionToId(S desc) throws ClassNotFoundException;

}
