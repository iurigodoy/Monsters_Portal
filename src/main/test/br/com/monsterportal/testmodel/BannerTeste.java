package br.com.monsterportal.testmodel;

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
		
		Banner obj = new Banner();
		
		obj.setArquivo("foto.jpg");
	    obj.criarHistorico();
		
		Assert.assertEquals("foto.jpg",obj.getArquivo());
	}
}