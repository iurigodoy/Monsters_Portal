package br.com.monsterportal.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Banner;

/*
 *
 * Testa modelo de Banner
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class BannerTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Banner obj = new Banner();
		
		obj.setId_banner(55);
		obj.setArquivo_ban("foto.jpg");
	    obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals(55,obj.getId_banner());
		Assert.assertEquals("foto.jpg",obj.getIdArquivo_banner());
	    
	    //	Padrão
	    Assert.assertEquals(hoje, ban.getCreated_at());
	    Assert.assertEquals(hoje, ban.getUpdated_at());
	    Assert.assertEquals(null, ban.getDeleted_at());
	    Assert.assertEquals(false,ban.getDeleted());
	}
}