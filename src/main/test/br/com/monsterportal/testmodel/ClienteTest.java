package br.com.monsterportal.testmodel;

import org.junit.Assert;
import org.junit.Test;

import br.com.monster.portal.model.Cliente;

/*
 *
 * Testa modelo de Cliente
 * 
 * @Author Iam Carvalho de Lima
 * @Version 1.0
 * 
 */

public class ClienteTest {

	@Test
	public void test() {
		
		Cliente cli = new Cliente();
		
	    cli.setNome_cli("Roger Chaves");
	    cli.setCnpj_cli("59.275.792/0001-50");
		cli.setCpf_cli("458.874.327-87");
	    cli.setEmail_cli("iamc13hotmail.com");
		cli.setSexo_cli("masculino e feminino");
		cli.setSenha_cli("485070@$");
		cli.setCep_cli("09132-560-78");
		cli.setEstado_cli("São Paulo");
		cli.setCidade_cli("São Paulo");
		cli.setEndereco_cli("Rua Nove de Setembro Azul");
		cli.setNumero_cli("7B");
		cli.setComplemento_cli("Bloco 9 Apartamento 89 ");
		cli.setResidencial_cli("(11) 4875-9569");
		cli.setCelular_cli("(11) 98467-2545");
		cli.criarHistorico();
		
	    Assert.assertEquals("Roger Chaves", cli.getNome_cli());
	    Assert.assertEquals("59.275.792/0001-50", cli.getCnpj_cli());
	    Assert.assertEquals("458.874.327-87", cli.getCpf_cli());
	    Assert.assertEquals("iamc13hotmail.com", cli.getEmail_cli());
	    Assert.assertEquals("masculino e feminino", cli.getSexo_cli());
		Assert.assertEquals("485070@$", cli.getSenha_cli());
		Assert.assertEquals("09132-560-78", cli.getCep_cli());
		Assert.assertEquals("São Paulo", cli.getEstado_cli());
		Assert.assertEquals("São Paulo", cli.getCidade_cli());
		Assert.assertEquals("Rua Nove de Setembro Azul", cli.getEndereco_cli());
		Assert.assertEquals("7B", cli.getNumero_cli());
		Assert.assertEquals("Bloco 9 Apartamento 89 ", cli.getComplemento_cli());
		Assert.assertEquals("(11) 4875-9569", cli.getResidencial_cli());
		Assert.assertEquals("(11) 98467-2545", cli.getCelular_cli());
	}
}