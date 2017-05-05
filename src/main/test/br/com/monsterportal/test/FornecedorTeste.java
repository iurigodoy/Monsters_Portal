package br.com.monsterportal.test;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Fornecedor;

/*
 *
 * Testa modelo de Fornecedor
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class FornecedorTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Fornecedor obj = new Fornecedor();
		
			    obj.setId_fornecedor(21);
				obj.setnome_fornecedor(" Valentina Ferragens ");
				obj.setcnpj_fornecedor("170258936457891234598" );
				obj.setlogo_fornecedor("Foto.jpg" );
				obj.setcep_fornecedor("0987515689" );
				obj.setestado_fornecedor("Rio de Janeiro" );
				obj.setcidade_fornecedor("Morro dos Macacos" );
				obj.setendereco_fornecedor("Rua dos Pinhais" );
				obj.setnumero_fornecedor("88895BCD" );
				obj.setcomplemento_fornecedor("Bloco 8 Apartamento 95" );
				obj.setemail_fornecedor("valentinaferragensgmail.com" );
				obj.setcomercial_fornecedor("(11) 4453-8914" );
				
				Assert.assertEquals(21,obj.getId_fornecedor());
				Assert.assertEquals("Valentina Ferragens",obj.getnome_fornecedor());
				Assert.assertEquals("170258936457891234598",obj.getcnpj_fornecedor());
				Assert.assertEquals("Foto.jpg",obj.getlogo_fornecedor());
				Assert.assertEquals("0987515689",obj.getcep_fornecedor());
				Assert.assertEquals("Rio de Janeiro",obj.getestado_fornecedor());
				Assert.assertEquals("Morro dos Macacos",obj.getcidade_fornecedor());
				Assert.assertEquals("Rua dos Pinhais",obj.getendereco_fornecedor());
				Assert.assertEquals("88895BCD",obj.getnumero_fornecedor());
				Assert.assertEquals("Bloco 8 Apartamento 95",obj.getcomplemento_fornecedor());
				Assert.assertEquals("valentinaferragensgmail",obj.getemail_fornecedor());
				Assert.assertEquals("(11) 4453-8914",obj.getcomercial_fornecedor());
				
				
		
			    //	Padrão
	    Assert.assertEquals(hoje, func.getCreated_at());
	    Assert.assertEquals(hoje, func.getUpdated_at());
	    Assert.assertEquals(null, func.getDeleted_at());
	    Assert.assertEquals(false, func.getDeleted());