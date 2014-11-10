package org.itsector.seamproject.validator;

import org.hibernate.validator.Validator;

public class MaiusculoValidator implements Validator<Maiusculo> {
	private Maiusculo anotacao;
	
	public void initialize(Maiusculo anotacao){
		this.anotacao = anotacao;
	}
	
	public boolean isValid(Object value){
		String asString=value.toString();
		return asString.equals(asString.toUpperCase());
	}
}
