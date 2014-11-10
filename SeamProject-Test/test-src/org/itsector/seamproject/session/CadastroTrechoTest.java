package org.itsector.seamproject.session;

import java.util.List;

import org.itsector.seamproject.domain.Localidade;
import org.itsector.seamproject.domain.Trecho;
import org.jboss.seam.mock.SeamTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CadastroTrechoTest extends SeamTest {

	@Test
	public void testTrechoPodeSerCadastrado() throws Exception{
		new ComponentTest(){
			protected void testComponents() throws Exception {
				setValue("#{trechoHandler.trecho.origem}",Localidade.SAO_PAULO);
				setValue("#{trechoHandler.trecho.destino}",Localidade.RIO_DE_JANEIRO);
				
				Assert.assertNull(invokeMethod("#{trechoHandler.salvar}"));
				
				//limpou dados apos salvar
				Assert.assertNull(getValue("#{trechoHandler.trecho.origem}"));
				Assert.assertNull(getValue("#{trechoHandler.trecho.destino}"));
				
				//entrou na lista de trechos
				List<Trecho> trechos= (List<Trecho>) getValue("#{trechos}");
				Assert.assertEquals(1,trechos.size());
				Assert.assertEquals(Localidade.SAO_PAULO,trechos.get(0).getOrigem());
				Assert.assertEquals(Localidade.RIO_DE_JANEIRO,trechos.get(0).getDestino());
			}
		}.run();
		

	}
}
