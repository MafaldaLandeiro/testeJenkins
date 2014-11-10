package org.itsector.seamproject.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Future;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.itsector.seamproject.validator.Maiusculo;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity

@Name("voo")
@Scope(ScopeType.EVENT)
public class Voo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Length(min=6,max=6)
	@Pattern(regex="[A-Z]{2}-[0-9]{3}")
	//@Maiusculo
	private String codigo;
	
	@Temporal(TemporalType.DATE)
	private Date dataPartida=new Date();
	
	@Temporal(TemporalType.TIME)
	private Date horaPartida= new Date();
	
	@Temporal(TemporalType.DATE)
	@Future
	private Date dataChegada = new Date();
	
	@Temporal(TemporalType.TIME)
	private Date horaChegada = new Date();
	
	@NotNull
	@ManyToOne
	private Trecho trecho;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Date horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Date getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Trecho getTrecho() {
		return trecho;
	}

	public void setTrecho(Trecho trecho) {
		this.trecho = trecho;
	}
	
	public String toString(){
		return String.format("{Voo id=%d, codigo=%s, horaPartida=%tR, dataPartida=%tD, trecho=%s}", id,codigo,horaPartida,dataPartida,trecho);
	}

}
