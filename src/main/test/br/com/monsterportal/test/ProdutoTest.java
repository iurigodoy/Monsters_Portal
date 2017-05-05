package br.com.monsterportal.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Produto;

/*
 *
 * Testa modelo de Produto
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class ProdutoTest {

	@Test
	public void test() {
		
		Produto obj = new Produto();
		
		obj.setNome_pro("Fogão");
		obj.setDescricao_pro("Bonito fogão 4 bocas ");
		obj.setPeso_pro("47");
		obj.setAltura_pro("78");
		obj.setLargura_pro("40");
		obj.setComprimento_pro("10");
		
		Assert.assertEquals("Fogão", obj.getNome_pro());
		Assert.assertEquals("Bonito fogão 4 bocas ",obj.getDescricao_pro());
		Assert.assertEquals("47",obj.getPeso_pro());
		Assert.assertEquals("78",obj.getAltura_pro());
		Assert.assertEquals("40",obj.getLargura_pro());
		Assert.assertEquals("10",obj.getComprimento_pro());
	}
}