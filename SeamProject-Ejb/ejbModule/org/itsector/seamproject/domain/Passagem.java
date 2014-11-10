package org.itsector.seamproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passagem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Voo voo;
	
	private String cliente;
	
	public Passagem(){
		
	}
	
	public Passagem(Voo voo,String cliente){
		this.voo=voo;
		this.cliente=cliente;
	}

	public long getId() {
		return id;
	}

	public Voo getVoo() {
		return voo;
	}

	public String getCliente() {
		return cliente;
	}
	
	
}
