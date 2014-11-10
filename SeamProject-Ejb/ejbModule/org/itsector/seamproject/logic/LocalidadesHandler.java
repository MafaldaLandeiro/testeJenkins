package org.itsector.seamproject.logic;

import org.itsector.seamproject.domain.Localidade;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Name("localidadesHandler")
public class LocalidadesHandler {
	
	@Logger
	private Log log;

	public LocalidadesHandler(){
		
	}
	
	@Factory(value = "localidades", scope = ScopeType.APPLICATION)
	public Localidade[] initLocalidades() {
		//log.info("Iniciando localidades");
		return Localidade.values();
	}

}
