package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Categoria;

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
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Categoria obj = new Categoria();
		
		obj.setId_categoria(589);
		obj.setNome_categoria("nome categoria");
		obj.setHierarquia_categoria();
		obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals(589, obj.getId_categoria());
		Assert.assertEquals("nome categoria", obj.getNome_Categoria());
		Assert.assertEquals(obj.getHierarquia_Categoria());
		
		//	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false, obj.getDeleted());
			}
}