package br.com.monsterportal.testmodel;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Cargo;

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
		
		Cargo obj = new Cargo();
		
		obj.setNome_car("Nome Cargo");
		obj.criarHistorico();
		
		Assert.assertEquals("Nome Cargo", obj.getNome_car());
	}
}