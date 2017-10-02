package br.com.monsterportal.testmodel;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Imagem;

/*
 *
 * Testa modelo de Imagem
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class ImagemTeste {

	@Test
	public void test() {
		
		Imagem obj = new Imagem();
		
		obj.setArquivo_ima("foto.jpg");
		
		Assert.assertEquals("foto.jpg",obj.getArquivo_ima());
			}
}