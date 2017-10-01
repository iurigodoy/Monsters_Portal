package br.com.monsterportal.testmodel;

import org.junit.Test;

import br.com.monster.portal.model.Pedido;

/*
 *
 * Testa modelo de Pedido
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class BannerTest {

	@Test
	public void test() {
		
		Pedido obj = new Pedido();
		
		obj.criarHistorico();
	}
}