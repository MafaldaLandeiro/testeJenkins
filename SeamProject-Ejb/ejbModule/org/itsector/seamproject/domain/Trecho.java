package org.itsector.seamproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.NotNull;

@Entity
public class Trecho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=20)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Localidade origem;
	
	@Column(length=20)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Localidade destino;
	
	
	@OneToMany(mappedBy="trecho", cascade=CascadeType.ALL)
	private List<Voo> voos= new ArrayList<Voo>();
	
	public List<Voo> getVoos(){
		return voos;
	}
	
	public void addVoo(Voo voo){
		voo.setTrecho(this);
		this.voos.add(voo);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Localidade getOrigem() {
		return origem;
	}

	public void setOrigem(Localidade origem) {
		this.origem = origem;
	}

	public Localidade getDestino() {
		return destino;
	}

	public void setDestino(Localidade destino) {
		this.destino = destino;
	}

	public void setVoos(List<Voo> voos) {
		this.voos = voos;
	}

	public String toString(){
		return String.format("{Trecho id:%d, origem:%s. destino:%s}", id,origem,destino);
	}
	
	
}
