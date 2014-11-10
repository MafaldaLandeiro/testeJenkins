package org.itsector.seamproject.domain;

public enum Localidade {
	
	SAO_PAULO("S�o Paulo"),
	RIO_DE_JANEIRO("Rio de Janeiro"),
	NOVA_IORQUE("Nova Iorque"),
	PARIS("Paris"),
	LONDRES("Londres"),
	MOSCOU("Moscou");
	
	private final String nome;
	
	private Localidade (String nome){
		this.nome=nome;
	}
	
	public String getNome(){
		return nome;
	}

}
