package br.com.monsterportal.test;

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
		obj.setnome_categoria("nome categoria");
		obj.setHierarquia_categoria();
		obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals(589, obj.getId_categoria());
		Assert.assertEquals("nome categoria", obj.getNome_Categoria());
		Assert.assertEquals(obj.getHierarquia_Categoria());
		
		//	Padrão
	    Assert.assertEquals(hoje, cat.getCreated_at());
	    Assert.assertEquals(hoje, cat.getUpdated_at());
	    Assert.assertEquals(null, cat.getDeleted_at());
	    Assert.assertEquals(false, cat.getDeleted());