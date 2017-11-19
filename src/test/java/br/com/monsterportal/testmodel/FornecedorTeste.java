package br.com.monsterportal.testmodel;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Fornecedor;

/*
 *
 * Testa modelo de Fornecedor
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class FornecedorTeste {

	@Test
	public void test() {
		
		Fornecedor obj = new Fornecedor();
		
				obj.setNome_for("Valentina Ferragens");
				obj.setCnpj_for("170258936457891234598" );
				obj.setLogo_for("Foto.jpg" );
				obj.setCep_for("0987515689" );
				obj.setEstado_for("Rio de Janeiro" );
				obj.setCidade_for("Morro dos Macacos" );
				obj.setEndereco_for("Rua dos Pinhais" );
				obj.setNumero_for("88895BCD" );
				obj.setComplemento_for("Bloco 8 Apartamento 95" );
				obj.setEmail_for("valentinaferragensgmail.com" );
				obj.setComercial_for("(11) 4453-8914" );
				obj.criarHistorico();
				
				Assert.assertEquals("Valentina Ferragens",obj.getNome_for());
				Assert.assertEquals("170258936457891234598",obj.getCnpj_for());
				Assert.assertEquals("Foto.jpg",obj.getLogo_for());
				Assert.assertEquals("0987515689",obj.getCep_for());
				Assert.assertEquals("Rio de Janeiro",obj.getEstado_for());
				Assert.assertEquals("Morro dos Macacos",obj.getCidade_for());
				Assert.assertEquals("Rua dos Pinhais",obj.getEndereco_for());
				Assert.assertEquals("88895BCD",obj.getNumero_for());
				Assert.assertEquals("Bloco 8 Apartamento 95",obj.getComplemento_for());
				Assert.assertEquals("valentinaferragensgmail.com",obj.getEmail_for());
				Assert.assertEquals("(11) 4453-8914",obj.getComercial_for());
	}
}