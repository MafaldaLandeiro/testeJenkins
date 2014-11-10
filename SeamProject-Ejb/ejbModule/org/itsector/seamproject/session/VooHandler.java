package org.itsector.seamproject.session;

import org.itsector.seamproject.domain.Trecho;

public interface VooHandler {
	
	String manipulaVoos(Trecho trecho);
	
	void destruicaoObrigatoria();
	
	 Trecho getTrechoSelecionado();
	 
	 String salvarVoo();
	 
	 void iniciaVoos();
	 
	 void editar();
	 
	 String remover();

}
