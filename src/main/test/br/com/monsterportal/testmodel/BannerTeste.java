package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Banner;

/*
 *
 * Testa modelo de Banner
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class BannerTeste {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Banner obj = new Banner();
		
		obj.setArquivo_ban("foto.jpg");
	    obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals("foto.jpg",obj.getArquivo_ban());
	    
	    //	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false,obj.getDeleted());
	}
}