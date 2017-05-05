package br.com.monsterportal.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Pedido_has_produto;

/*
 *
 * Testa modelo de Pedido_has_produto
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class Pedido_has_produtoTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Pedido_has_produto obj = new Pedido_has_produto();
		
		obj.setId_prod(231);
		obj.setquantidade_prod(456);
		
		Assert.assertEquals(231,obj.getId_prod());
		Assert.assertEquals(456,obj.getquantidade_prod());
		
		//	Padrão
	    Assert.assertEquals(hoje, prod.getCreated_at());
	    Assert.assertEquals(hoje, prod.getUpdated_at());
	    Assert.assertEquals(null, prod.getDeleted_at());
	    Assert.assertEquals(false,prod.getDeleted());