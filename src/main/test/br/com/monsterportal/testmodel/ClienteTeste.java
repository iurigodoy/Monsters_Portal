package br.com.monsterportal.testmodel;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.com.help.desk.model.Cliente;

/*
 *
 * Testa modelo de Cliente
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class FuncionarioTest {

	@Test
	public void test() {
		// Pega a hora
		Date hoje = new GregorianCalendar().getTime();
		
		Cliente obj = new Cliente();
		
		obj.setId_Cliente(500);
	    obj.setNome_cli("Roger Chaves");
	    obj.setCnpj_cli("59.275.792/0001-50");
		obj.setCpf_cli("458.874.327-87");
	    obj.setEmail_cli("iamc13hotmail.com");
		obj.setSexo_cli("masculino e feminino");
		obj.setSenha_cli("485070@$");
		obj.setCep_cli("09132-560-78");
		obj.setEstado_cli("São Paulo");
		obj.setCidade_cli("São Paulo");
		obj.setEndereco_cli("Rua Nove de Setembro Azul");
		obj.setNumero_cli("7B");
		obj.setComplemento_cli("Bloco 9 Apartamento 89 ");
		obj.setResidencial_cli("(11) 4875-9569");
		obj.setCelular_cli("(11) 98467-2545");
		obj.setCreated_at(hoje);
	    obj.setUpdated_at(hoje);
	    obj.setDeleted_at(null);
	    obj.setDeleted(false);
		
		Assert.assertEquals(500, obj.getId_Cliente());
	    Assert.assertEquals("Roger Chaves", obj.getNome_cli());
	    Assert.assertEquals("59.275.792/0001-50", cli.getcnpj_cli());
	    Assert.assertEquals("458.874.327-87", cli.getcpf_cli());
	    Assert.assertEquals("iamc13hotmail.com", cli.getemail_cli());
	    Assert.assertEquals("masculino e feminino", cli.getsexo_cli());
		Assert.assertEquals("485070@$", cli.getsenha_cli());
		Assert.assertEquals("09132-560-78", cli.getcep_cli());
		Assert.assertEquals("São Paulo", cli.getestado_cli());
		Assert.assertEquals("São Paulo", cli.getcidade_cli());
		Assert.assertEquals("Rua Nove de Setembro Azul", cli.getendereco_cli());
		Assert.assertEquals("7B", cli.getnumero_cli());
		Assert.assertEquals("Bloco 9 Apartamento 89 ", cli.getcomplemento_cli());
		Assert.assertEquals("(11) 4875-9569", cli.getresidencial_cli());
		Assert.assertEquals("(11) 98467-2545", cli.getcelular_cli());
		
		
		//	Padrão
	    Assert.assertEquals(hoje, obj.getCreated_at());
	    Assert.assertEquals(hoje, obj.getUpdated_at());
	    Assert.assertEquals(null, obj.getDeleted_at());
	    Assert.assertEquals(false, obj.getDeleted());
			}
}