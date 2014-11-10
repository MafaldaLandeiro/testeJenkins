package org.itsector.seamproject.session;


import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.itsector.seamproject.domain.Trecho;
import org.itsector.seamproject.exception.DAOException;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.core.Events;
import org.jboss.seam.log.Log;

@Name("trechoHandler")
@Scope(ScopeType.EVENT)
public class TrechoHandler {
	
	@In
	private EntityManager entityManager;
	
	@DataModel
	private List<Trecho> trechos;
	
	@DataModelSelection
	private Trecho trechoSelecionado;
	
	@Logger
	private Log log;
	
	@In
	private Events events;

	private Trecho trecho=new Trecho();
	
	@Factory("trechos")
	public void populaTrechos(){
		log.info("Buscando trechos do Banco de dados");
		this.trechos = this.entityManager.createQuery("from Trecho").getResultList();
	}
	
	public Trecho getTrecho(){
		return this.trecho;
	}
	
	public void editar(){
		this.trecho=trechoSelecionado;
	}
	
	public void salvar(final ActionEvent event){
		//log.info("Salvando:#0",this.trecho);
		entityManager.merge(trecho);
		events.raiseEvent("novoTrecho", this.trecho);
		trecho=new Trecho();

	}
	
	public String remover(){
		this.entityManager.remove(trechoSelecionado);
		throw new DAOException();
		//return "/trechos.xhtml";
	}
}
