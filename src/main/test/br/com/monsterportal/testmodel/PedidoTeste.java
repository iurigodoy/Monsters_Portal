package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Pedido;

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
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Pedido obj = new Pedido();
		
		obj.setId_pedido(200);
		obj.setNumero_ped("500");
		obj.setParcelas_ped(20);
		obj.setStatus_ped(1);
		obj.setPeso_ped("50");
		obj.setAltura_ped("10");
		obj.setLargura_ped("56");
		obj.setComprimento_ped("21");
		obj.setCreated_at(hoje);
		obj.setUpdated_at(hoje);
		obj.setDeleted_at(null);
		obj.setDeleted(false);
		
		Assert.assertEquals(200,obj.getId_pedido());
		Assert.assertEquals("500",obj.getnumero_pedido());
		Assert.assertEquals(20,obj.getparcelas_pedido());
		Assert.assertEquals(1,obj.getstatus_pedido());
		Assert.assertEquals("50",obj.getpeso_pedido());
		Assert.assertEquals("10",obj.getaltura_pedido());
		Assert.assertEquals("56",obj.getlargura_pedido());
		Assert.assertEquals("21",obj.getcomprimento_pedido());
		
		
		//	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false,obj.getDeleted());
			}
}