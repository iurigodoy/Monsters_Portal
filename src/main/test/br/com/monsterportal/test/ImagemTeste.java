package br.com.monsterportal.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Imagem;

/*
 *
 * Testa modelo de Imagem
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class ImagemTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Imagem obj = new Imagem();
		
		obj.setId_imagem(105);
		obj.setordem_imagem();
		obj.setarquivo_imagem("Foto.jpg");
		
		Assert.assertEquals(105,obj.getId_imagem());
		Assert.assertEquals(,obj.getordem,_imagem());
		Assert.assertEquals("foto.jpg",obj.getarquivo_imagem());
		
		//	Padrão
	    Assert.assertEquals(hoje, ima.getCreated_at());
	    Assert.assertEquals(hoje, ima.getUpdated_at());
	    Assert.assertEquals(null, ima.getDeleted_at());
	    Assert.assertEquals(false, ima.getDeleted());