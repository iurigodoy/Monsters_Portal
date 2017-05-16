package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Produto_has_fornecedor;

/*
 *
 * Testa modelo de Produto_has_fornecedor
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class Produto_has_fornecedorTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Produto_has_fornecedor obj = new Produto_has_fornecedor();
		
		obj.setId_Produto_has_fornecedor(748);
		obj.setQuantidade_Produto_has_fornecedor(2);
		obj.setGarantia_Produto_has_fornecedor(15);
		obj.setCreated_at(hoje);
		obj.setUpdated_at(hoje);
		obj.setDeleted_at(null);
		obj.setDeleted(false);
		
		Assert.assertEquals(748,obj.getId_Produto_has_fornecedor());
		Assert.assertEquals(2,obj.getIdquantidade_Produto_has_fornecedor());
		Assert.assertEquals(15,obj.getIdgarantia_Produto_has_fornecedor());
		
		
		//	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false,obj.getDeleted());
	}
}