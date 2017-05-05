package br.com.monsterportal.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Cargo;

/*
 *
 * Testa modelo de Cargo
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class CargoTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Cargo obj = new Cargo();
		
		obj.setId_cargo(70);
		obj.setNome_cargo("Nome Cargo");
		obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals(70, obj.getId_cargo());
		Assert.assertEquals("Nome Cargo", obj.getNome_cargo());
		
		
		
		
		//	Padrão
	    Assert.assertEquals(hoje, car.getCreated_at());
	    Assert.assertEquals(hoje, car.getUpdated_at());
	    Assert.assertEquals(null, car.getDeleted_at());
	    Assert.assertEquals(false, car.getDeleted());