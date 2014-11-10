package org.itsector.seamproject.session;

import org.itsector.seamproject.domain.Trecho;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

@Name("auditoria")
@Scope(ScopeType.EVENT)
public class AuditoriaHandler {
	@Logger
	private Log log;
	
	@Observer("novoTrecho")
	public void registraQueTrechoFoiAdicionado(Trecho trecho){
		log.info("Novo Trecho registrado! #0", trecho);
	}
	
}
