package br.com.monsterportal.testmodel;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Categoria;

/*
 *
 * Testa modelo de Categoria
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class CategoriaTest {

	@Test
	public void test() {
		
		Categoria obj = new Categoria();
		
		obj.setNome_cat("nome categoria");
		obj.criarHistorico();
		
		Assert.assertEquals("nome categoria", obj.getNome_cat());
	}
}