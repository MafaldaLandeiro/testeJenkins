package org.itsector.seamproject.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.itsector.seamproject.domain.Trecho;
import org.itsector.seamproject.domain.Voo;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.log.Log;

@Stateful
@Local(VooHandler.class)
@Name("vooHandler")
@Scope(ScopeType.CONVERSATION)
public class VooHandlerBean implements VooHandler {

	@PersistenceContext(unitName = "SeamProject", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Logger
	private Log log;

	private Trecho trechoSelecionado;

	@DataModelSelection
	private Voo vooSelecionado;

	@In(required = false)
	@Out(required = false)
	private Voo voo;

	@DataModel
	private List<Voo> voos;

	@Factory("voos")
	public void iniciaVoos() {
		this.voos = this.trechoSelecionado.getVoos();
	}

	public String salvarVoo() {

	  this.voo.setTrecho(this.trechoSelecionado);
	  if (this.voo.getId() != null) {
		   List<Voo> voosAux = this.trechoSelecionado.getVoos();
		   for (int i = 0; i < voosAux.size(); i++) {
			    if (voosAux.get(i).getId().equals(this.voo.getId())) {
				     this.voo = this.entityManager.merge(this.voo);
				     this.trechoSelecionado.getVoos().set(i, this.voo);
				     break;
			    }
		   }
	  } else {
		   this.voo = this.entityManager.merge(this.voo);
		   this.trechoSelecionado.addVoo(this.voo);
	  }
	  log.info("Salvando Voo #0", voo);
	  this.voo = new Voo();
	  return "/voos.xhtml";
	}

	public void editar() {
		this.voo = vooSelecionado;
	}

	public String remover() {
		this.trechoSelecionado.getVoos().remove(this.vooSelecionado);
		this.entityManager.remove(this.vooSelecionado);
		return "/voos.xhtml";
	}

	@Begin
	@Restrict("#{s:hasRole('empresa')}")
	public String manipulaVoos(Trecho trecho) {
		this.trechoSelecionado = this.entityManager.merge(trecho);
		log.info("entitymanager = #0", entityManager);
		log.info("Trecho selecionado: #0", this.trechoSelecionado);
		return "/voos.xhtml";
	}

	public Trecho getTrechoSelecionado() {
		return this.trechoSelecionado;
	}

	public Voo getVooSelecionado() {
		return this.vooSelecionado;
	}

	@Remove
	@Destroy
	public void destruicaoObrigatoria() {
		log.info("Chamando metodo de destruicao obrigatoria");
	}

}
