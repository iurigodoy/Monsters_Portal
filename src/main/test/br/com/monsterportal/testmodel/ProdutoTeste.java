package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

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

public class ProdutoTeste {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Produto obj = new Produto();
		
		obj.setId_produto((long) 289);
		obj.setNome_pro("Fogão");
		obj.setDescricao_pro("Bonito fogão 4 bocas ");
		obj.setDesconto_pro(0.50);
		obj.setPeso_pro(0.47);
		obj.setAltura_pro(0.78);
		obj.setLargura_pro(0.40);
		obj.setComprimento_pro(0.10);
		obj.setCreated_at(hoje);
		obj.setUpdated_at(hoje);
		obj.setDeleted_at(null);
		obj.setDeleted(false);
		
		Assert.assertEquals("fogão",obj.getNome_pro());
		Assert.assertEquals("Bonito fogão 4 bocas ",obj.getDescricao_pro());
		Assert.assertEquals("47",obj.getPeso_pro());
		Assert.assertEquals("78",obj.getAltura_pro());
		Assert.assertEquals("40",obj.getLargura_pro());
		Assert.assertEquals("10",obj.getComprimento_pro());
		
		
		//	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false,obj.getDeleted());
			}
}