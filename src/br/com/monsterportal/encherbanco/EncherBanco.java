package br.com.monsterportal.encherbanco;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.model.Permissao;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;

public class EncherBanco {
	public static void main(String[] args) {
		
		//Pegar a hora
		Calendar cal = new GregorianCalendar();
		
		/*
		 * 
		 * Permissao
		 * 
		 */
		
		Permissao permissao = new Permissao();
		
		permissao.setAtualizarBanner(true);
		permissao.setAtualizarCargo(true);
		permissao.setAtualizarCategoria(true);
		permissao.setAtualizarCliente(true);
		permissao.setAtualizarFornecedor(true);
		permissao.setAtualizarFuncionario(true);
		permissao.setAtualizarPedido(true);
		permissao.setAtualizarProduto(true);
		
		permissao.setCriarBanner(true);
		permissao.setCriarCampanha(true);
		permissao.setCriarCargo(true);
		permissao.setCriarCategoria(true);
		permissao.setCriarCliente(true);
		permissao.setCriarFornecedor(true);
		permissao.setCriarFuncionario(true);
		permissao.setCriarPedido(true);
		permissao.setCriarProduto(true);

		permissao.setLerBanner(true);
		permissao.setLerCampanha(true);
		permissao.setLerCargo(true);
		permissao.setLerCategoria(true);
		permissao.setLerCliente(true);
		permissao.setLerFornecedor(true);
		permissao.setLerFuncionario(true);
		permissao.setLerPedido(true);
		permissao.setLerProduto(true);
		
		permissao.setExcluirBanner(true);
		permissao.setExcluirCampanha(true);
		permissao.setExcluirCargo(true);
		permissao.setExcluirCategoria(true);
		permissao.setExcluirCliente(true);
		permissao.setExcluirFornecedor(true);
		permissao.setExcluirFuncionario(true);
		permissao.setExcluirPedido(true);
		permissao.setExcluirProduto(true);
		
		permissao.setRestaurarBanner(true);
		permissao.setRestaurarCampanha(true);
		permissao.setRestaurarCargo(true);
		permissao.setRestaurarCategoria(true);
		permissao.setRestaurarCliente(true);
		permissao.setRestaurarFornecedor(true);
		permissao.setRestaurarFuncionario(true);
		permissao.setRestaurarPedido(true);
		permissao.setRestaurarProduto(true);
		
		
		Permissao permissao1 = new Permissao();
		
		permissao1.setAtualizarBanner(true);
		permissao1.setAtualizarCargo(true);
		permissao1.setAtualizarCategoria(true);
		permissao1.setAtualizarCliente(true);
		permissao1.setAtualizarFornecedor(true);
		permissao1.setAtualizarFuncionario(true);
		permissao1.setAtualizarPedido(true);
		permissao1.setAtualizarProduto(true);
		
		permissao1.setCriarBanner(true);
		permissao1.setCriarCampanha(true);
		permissao1.setCriarCargo(true);
		permissao1.setCriarCategoria(true);
		permissao1.setCriarCliente(true);
		permissao1.setCriarFornecedor(true);
		permissao1.setCriarFuncionario(true);
		permissao1.setCriarPedido(true);
		permissao1.setCriarProduto(true);

		permissao1.setLerBanner(true);
		permissao1.setLerCampanha(true);
		permissao1.setLerCargo(true);
		permissao1.setLerCategoria(true);
		permissao1.setLerCliente(true);
		permissao1.setLerFornecedor(true);
		permissao1.setLerFuncionario(true);
		permissao1.setLerPedido(true);
		permissao1.setLerProduto(true);
		
		permissao1.setExcluirBanner(false);
		permissao1.setExcluirCampanha(false);
		permissao1.setExcluirCargo(false);
		permissao1.setExcluirCategoria(false);
		permissao1.setExcluirCliente(false);
		permissao1.setExcluirFornecedor(false);
		permissao1.setExcluirFuncionario(false);
		permissao1.setExcluirPedido(false);
		permissao1.setExcluirProduto(false);
		
		permissao1.setRestaurarBanner(false);
		permissao1.setRestaurarCampanha(false);
		permissao1.setRestaurarCargo(false);
		permissao1.setRestaurarCategoria(false);
		permissao1.setRestaurarCliente(false);
		permissao1.setRestaurarFornecedor(false);
		permissao1.setRestaurarFuncionario(false);
		permissao1.setRestaurarPedido(false);
		permissao1.setRestaurarProduto(false);
		
		Cargo cargo = new Cargo();

		cargo.setNome_car("Super Usuário");
		cargo.setPadrao_car(false);
	    cargo.setCreated_at(cal.getTime());
		cargo.setUpdated_at(cal.getTime());
	    cargo.setDeleted_at(null);
	    cargo.setDeleted(false);
		
		Cargo cargo1 = new Cargo();

		cargo1.setNome_car("Medio Usuário");
		cargo1.setPadrao_car(true);
	    cargo1.setCreated_at(cal.getTime());
		cargo1.setUpdated_at(cal.getTime());
	    cargo1.setDeleted_at(null);
	    cargo1.setDeleted(false);
		
		Funcionario funcionario = new Funcionario();

		funcionario.setNome_fun("Iuri Godoy");
		funcionario.setFoto_fun("foto6.jpg");
		funcionario.setCpf_fun("435.628.318-03");
		funcionario.setEmail_fun("iurigodoy@hotmail.com");
		funcionario.setCelular_fun("11 968651313");
		funcionario.setResidencial_fun("11 32136636");
		funcionario.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario.getSenha_fun()+"------------------------------------------------------------");
		funcionario.setBloqueado_fun(false);
		
		Funcionario funcionario1 = new Funcionario();

		funcionario1.setNome_fun("Caue Silva");
		funcionario1.setFoto_fun("foto3.jpg");
		funcionario1.setCpf_fun("408.750.798-06");
		funcionario1.setEmail_fun("cauueh@hotmail.com");
		funcionario1.setCelular_fun("11 953200491");
		funcionario1.setResidencial_fun("11 28564221");
		funcionario1.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario1.getSenha_fun()+"------------------------------------------------------------");
		funcionario1.setBloqueado_fun(false);
		
		Funcionario funcionario2 = new Funcionario();

		funcionario2.setNome_fun("Iam Carvalho");
		funcionario2.setFoto_fun("foto2.jpg");
		funcionario2.setCpf_fun("405.751.797-06");
		funcionario2.setEmail_fun("iam@hotmail.com");
		funcionario2.setCelular_fun("11 983200991");
		funcionario2.setResidencial_fun("11 26548796");
		funcionario2.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario2.getSenha_fun()+"------------------------------------------------------------");
		funcionario2.setBloqueado_fun(false);
		
		Funcionario funcionario3 = new Funcionario();

		funcionario3.setNome_fun("Leandro Domiciano");
		funcionario3.setFoto_fun("foto4.jpg");
		funcionario3.setCpf_fun("409.771.585-01");
		funcionario3.setEmail_fun("leandro.domi@hotmail.com");
		funcionario3.setCelular_fun("11 993204981");
		funcionario3.setResidencial_fun("11 29588796");
		funcionario3.criptografar_senha("123456");
		System.out.println("-------------------------------------------------"+funcionario3.getSenha_fun()+"------------------------------------------------------------");
		funcionario3.setBloqueado_fun(false);
		
		
	    // Histórico
	    funcionario.setCreated_at(cal.getTime());
		funcionario.setUpdated_at(cal.getTime());
	    funcionario.setDeleted_at(null);
	    funcionario.setDeleted(false);
	    // Histórico
	    funcionario1.setCreated_at(cal.getTime());
		funcionario1.setUpdated_at(cal.getTime());
	    funcionario1.setDeleted_at(null);
	    funcionario1.setDeleted(false);
	    // Histórico
	    funcionario2.setCreated_at(cal.getTime());
		funcionario2.setUpdated_at(cal.getTime());
	    funcionario2.setDeleted_at(null);
	    funcionario2.setDeleted(false);
	    // Histórico
	    funcionario3.setCreated_at(cal.getTime());
		funcionario3.setUpdated_at(cal.getTime());
	    funcionario3.setDeleted_at(null);
	    funcionario3.setDeleted(false);

		/*
		 * 
		 * Categoria
		 * 
		 */
		
		Categoria celular = new Categoria();
		celular.setNome_cat("celular");
		celular.setHierarquia_cat(0);
	    // Histórico
	    celular.setCreated_at(cal.getTime());
		celular.setUpdated_at(cal.getTime());
	    celular.setDeleted_at(null);
	    celular.setDeleted(false);
		
		Categoria eletronico = new Categoria();
		eletronico.setNome_cat("eletrodomestico");
		eletronico.setHierarquia_cat(0);
	    // Histórico
	    eletronico.setCreated_at(cal.getTime());
		eletronico.setUpdated_at(cal.getTime());
	    eletronico.setDeleted_at(null);
	    eletronico.setDeleted(false);
		
		Categoria acessorios = new Categoria();
		acessorios.setNome_cat("eletroeletronico");
		acessorios.setHierarquia_cat(0);
	    // Histórico
	    acessorios.setCreated_at(cal.getTime());
		acessorios.setUpdated_at(cal.getTime());
	    acessorios.setDeleted_at(null);
	    acessorios.setDeleted(false);
		
		Categoria games = new Categoria();
		games.setNome_cat("games");
		games.setHierarquia_cat(0);	
		
	    // Histórico
	    games.setCreated_at(cal.getTime());
		games.setUpdated_at(cal.getTime());
	    games.setDeleted_at(null);
	    games.setDeleted(false);
	    
		/*
		 * 
		 * Produto
		 * 
		 */
	    
	    Produto produto = new Produto();
	    
	    produto.setNome_pro("Samsung");
	    produto.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto.setCategoria(games);
	    // MKT
	    produto.setPromocao_pro(true);
	    produto.setPublicado_pro(true);
	    produto.setDesconto_pro(0.10);
	    produto.setDestaque_pro(true);
	    // Logistica
	    produto.setPeso_pro(0.100);
	    produto.setAltura_pro(20.000);
	    produto.setLargura_pro(20.000);
	    produto.setComprimento_pro(20.000);
	    produto.setDiametro_pro(20.000);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
	    
		Produto produto1 = new Produto();
	    
	    produto1.setNome_pro("Lg");
	    produto1.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto1.setCategoria(eletronico);
	    // MKT
	    produto1.setPromocao_pro(true);
	    produto1.setPublicado_pro(true);
	    produto1.setDesconto_pro(0.10);
	    produto1.setDestaque_pro(true);
	    // Logistica
	    produto1.setPeso_pro(0.100);
	    produto1.setAltura_pro(20.000);
	    produto1.setLargura_pro(20.000);
	    produto1.setComprimento_pro(20.000);
	    produto1.setDiametro_pro(20.000);
	    // Histórico
	    produto1.setCreated_at(cal.getTime());
		produto1.setUpdated_at(cal.getTime());
	    produto1.setDeleted_at(null);
	    produto1.setDeleted(false);
		
		Produto produto2 = new Produto();
	    
	    produto2.setNome_pro("Motorola");
	    produto2.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto2.setCategoria(acessorios);
	    // MKT
	    produto2.setPromocao_pro(true);
	    produto2.setPublicado_pro(true);
	    produto2.setDesconto_pro(0.10);
	    produto2.setDestaque_pro(false);
	    // Logistica
	    produto2.setPeso_pro(0.100);
	    produto2.setAltura_pro(20.000);
	    produto2.setLargura_pro(20.000);
	    produto2.setComprimento_pro(20.000);
	    produto2.setDiametro_pro(20.000);
	    // Histórico
	    produto2.setCreated_at(cal.getTime());
		produto2.setUpdated_at(cal.getTime());
	    produto2.setDeleted_at(null);
	    produto2.setDeleted(false);
		
		Produto produto3 = new Produto();
	    
	    produto3.setNome_pro("Samsung test");
	    produto3.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto3.setCategoria(celular);
	    // MKT
	    produto3.setPromocao_pro(true);
	    produto3.setPublicado_pro(true);
	    produto3.setDesconto_pro(0.10);
	    produto3.setDestaque_pro(false);
	    // Logistica
	    produto3.setPeso_pro(0.100);
	    produto3.setAltura_pro(20.000);
	    produto3.setLargura_pro(20.000);
	    produto3.setComprimento_pro(20.000);
	    produto3.setDiametro_pro(20.000);
	    // Histórico
	    produto3.setCreated_at(cal.getTime());
		produto3.setUpdated_at(cal.getTime());
	    produto3.setDeleted_at(null);
	    produto3.setDeleted(false);
		
		Produto produto4 = new Produto();
	    
	    produto4.setNome_pro("Cafeteira Elétrica Philips Walita RI7546");
	    produto4.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto4.setCategoria(games);
	    // MKT
	    produto4.setPromocao_pro(true);
	    produto4.setPublicado_pro(true);
	    produto4.setDesconto_pro(0.10);
	    produto4.setDestaque_pro(false);
	    // Logistica
	    produto4.setPeso_pro(0.100);
	    produto4.setAltura_pro(20.000);
	    produto4.setLargura_pro(20.000);
	    produto4.setComprimento_pro(20.000);
	    produto4.setDiametro_pro(20.000);
	    // Histórico
	    produto4.setCreated_at(cal.getTime());
		produto4.setUpdated_at(cal.getTime());
	    produto4.setDeleted_at(null);
	    produto4.setDeleted(false);
		
		Produto produto5 = new Produto();
	    
	    produto5.setNome_pro("Samsung test");
	    produto5.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto5.setCategoria(eletronico);
	    // MKT
	    produto5.setPromocao_pro(true);
	    produto5.setPublicado_pro(true);
	    produto5.setDesconto_pro(0.10);
	    produto5.setDestaque_pro(false);
	    // Logistica
	    produto5.setPeso_pro(0.100);
	    produto5.setAltura_pro(20.000);
	    produto5.setLargura_pro(20.000);
	    produto5.setComprimento_pro(20.000);
	    produto5.setDiametro_pro(20.000);
	    // Histórico
	    produto5.setCreated_at(cal.getTime());
		produto5.setUpdated_at(cal.getTime());
	    produto5.setDeleted_at(null);
	    produto5.setDeleted(false);
		
		Produto produto6 = new Produto();
	    
	    produto6.setNome_pro("Samsung test");
	    produto6.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto6.setCategoria(acessorios);
	    // MKT
	    produto6.setPromocao_pro(true);
	    produto6.setPublicado_pro(true);
	    produto6.setDesconto_pro(0.10);
	    produto6.setDestaque_pro(false);
	    // Logistica
	    produto6.setPeso_pro(0.100);
	    produto6.setAltura_pro(20.000);
	    produto6.setLargura_pro(20.000);
	    produto6.setComprimento_pro(20.000);
	    produto6.setDiametro_pro(20.000);
	    // Histórico
	    produto6.setCreated_at(cal.getTime());
		produto6.setUpdated_at(cal.getTime());
	    produto6.setDeleted_at(null);
	    produto6.setDeleted(false);
		
		Produto produto7 = new Produto();
	    
	    produto7.setNome_pro("Samsung test");
	    produto7.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto7.setCategoria(celular);
	    // MKT
	    produto7.setPromocao_pro(true);
	    produto7.setPublicado_pro(true);
	    produto7.setDesconto_pro(0.10);
	    produto7.setDestaque_pro(false);
	    // Logistica
	    produto7.setPeso_pro(0.100);
	    produto7.setAltura_pro(20.000);
	    produto7.setLargura_pro(20.000);
	    produto7.setComprimento_pro(20.000);
	    produto7.setDiametro_pro(20.000);
	    // Histórico
	    produto7.setCreated_at(cal.getTime());
		produto7.setUpdated_at(cal.getTime());
	    produto7.setDeleted_at(null);
	    produto7.setDeleted(false);
		
		Produto produto8 = new Produto();
	    
	    produto8.setNome_pro("Samsung test");
	    produto8.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto8.setCategoria(games);
	    // MKT
	    produto8.setPromocao_pro(true);
	    produto8.setPublicado_pro(true);
	    produto8.setDesconto_pro(0.10);
	    produto8.setDestaque_pro(false);
	    // Logistica
	    produto8.setPeso_pro(0.100);
	    produto8.setAltura_pro(20.000);
	    produto8.setLargura_pro(20.000);
	    produto8.setComprimento_pro(20.000);
	    produto8.setDiametro_pro(20.000);
	    // Histórico
	    produto8.setCreated_at(cal.getTime());
		produto8.setUpdated_at(cal.getTime());
	    produto8.setDeleted_at(null);
	    produto8.setDeleted(false);
		
		Produto produto9 = new Produto();
	    
	    produto9.setNome_pro("Samsung test");
	    produto9.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto9.setCategoria(eletronico);
	    // MKT
	    produto9.setPromocao_pro(true);
	    produto9.setPublicado_pro(true);
	    produto9.setDesconto_pro(0.10);
	    produto9.setDestaque_pro(false);
	    // Logistica
	    produto9.setPeso_pro(0.100);
	    produto9.setAltura_pro(20.000);
	    produto9.setLargura_pro(20.000);
	    produto9.setComprimento_pro(20.000);
	    produto9.setDiametro_pro(20.000);
	    // Histórico
	    produto9.setCreated_at(cal.getTime());
		produto9.setUpdated_at(cal.getTime());
	    produto9.setDeleted_at(null);
	    produto9.setDeleted(false);
		
		Produto produto10 = new Produto();
	    
	    produto10.setNome_pro("Samsung test");
	    produto10.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto10.setCategoria(acessorios);
	    // MKT
	    produto10.setPromocao_pro(true);
	    produto10.setPublicado_pro(true);
	    produto10.setDesconto_pro(0.10);
	    produto10.setDestaque_pro(false);
	    // Logistica
	    produto10.setPeso_pro(0.100);
	    produto10.setAltura_pro(20.000);
	    produto10.setLargura_pro(20.000);
	    produto10.setComprimento_pro(20.000);
	    produto10.setDiametro_pro(20.000);
	    // Histórico
	    produto10.setCreated_at(cal.getTime());
		produto10.setUpdated_at(cal.getTime());
	    produto10.setDeleted_at(null);
	    produto10.setDeleted(false);
		
		Produto produto11 = new Produto();
	    
	    produto11.setNome_pro("Samsung test");
	    produto11.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto11.setCategoria(celular);
	    // MKT
	    produto11.setPromocao_pro(true);
	    produto11.setPublicado_pro(true);
	    produto11.setDesconto_pro(0.10);
	    produto11.setDestaque_pro(false);
	    // Logistica
	    produto11.setPeso_pro(0.100);
	    produto11.setAltura_pro(20.000);
	    produto11.setLargura_pro(20.000);
	    produto11.setComprimento_pro(20.000);
	    produto11.setDiametro_pro(20.000);
	    // Histórico
	    produto11.setCreated_at(cal.getTime());
		produto11.setUpdated_at(cal.getTime());
	    produto11.setDeleted_at(null);
	    produto11.setDeleted(false);
		
		Produto produto12 = new Produto();
	    
	    produto12.setNome_pro("Samsung test");
	    produto12.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto12.setCategoria(celular);
	    // MKT
	    produto12.setPromocao_pro(true);
	    produto12.setPublicado_pro(true);
	    produto12.setDesconto_pro(0.10);
	    produto12.setDestaque_pro(false);
	    // Logistica
	    produto12.setPeso_pro(0.100);
	    produto12.setAltura_pro(20.000);
	    produto12.setLargura_pro(20.000);
	    produto12.setComprimento_pro(20.000);
	    produto12.setDiametro_pro(20.000);
	    // Histórico
	    produto12.setCreated_at(cal.getTime());
		produto12.setUpdated_at(cal.getTime());
	    produto12.setDeleted_at(null);
	    produto12.setDeleted(false);
		
		
		Produto produto13 = new Produto();
	    
	    produto13.setNome_pro("Samsung test");
	    produto13.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto13.setCategoria(celular);
	    // MKT
	    produto13.setPromocao_pro(true);
	    produto13.setPublicado_pro(true);
	    produto13.setDesconto_pro(0.10);
	    produto13.setDestaque_pro(false);
	    // Logistica
	    produto13.setPeso_pro(0.100);
	    produto13.setAltura_pro(20.000);
	    produto13.setLargura_pro(20.000);
	    produto13.setComprimento_pro(20.000);
	    produto13.setDiametro_pro(20.000);
	    // Histórico
	    produto13.setCreated_at(cal.getTime());
		produto13.setUpdated_at(cal.getTime());
	    produto13.setDeleted_at(null);
	    produto13.setDeleted(false);
		
		Produto produto14 = new Produto();
	    
	    produto14.setNome_pro("Samsung test");
	    produto14.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto14.setCategoria(celular);
	    // MKT
	    produto14.setPromocao_pro(true);
	    produto14.setPublicado_pro(true);
	    produto14.setDesconto_pro(0.10);
	    produto14.setDestaque_pro(false);
	    // Logistica
	    produto14.setPeso_pro(0.100);
	    produto14.setAltura_pro(20.000);
	    produto14.setLargura_pro(20.000);
	    produto14.setComprimento_pro(20.000);
	    produto14.setDiametro_pro(20.000);
	    // Histórico
	    produto14.setCreated_at(cal.getTime());
		produto14.setUpdated_at(cal.getTime());
	    produto14.setDeleted_at(null);
	    produto14.setDeleted(false);
		
		Produto produto15 = new Produto();
	    
	    produto15.setNome_pro("Samsung test");
	    produto15.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto15.setCategoria(eletronico);
	    // MKT
	    produto15.setPromocao_pro(true);
	    produto15.setPublicado_pro(true);
	    produto15.setDesconto_pro(0.10);
	    produto15.setDestaque_pro(false);
	    // Logistica
	    produto15.setPeso_pro(0.100);
	    produto15.setAltura_pro(20.000);
	    produto15.setLargura_pro(20.000);
	    produto15.setComprimento_pro(20.000);
	    produto15.setDiametro_pro(20.000);
	    // Histórico
	    produto15.setCreated_at(cal.getTime());
		produto15.setUpdated_at(cal.getTime());
	    produto15.setDeleted_at(null);
	    produto15.setDeleted(false);
		
		Produto produto16 = new Produto();
	    
	    produto16.setNome_pro("Samsung test");
	    produto16.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto16.setCategoria(celular);
	    // MKT
	    produto16.setPromocao_pro(true);
	    produto16.setPublicado_pro(true);
	    produto16.setDesconto_pro(0.10);
	    produto16.setDestaque_pro(false);
	    // Logistica
	    produto16.setPeso_pro(0.100);
	    produto16.setAltura_pro(20.000);
	    produto16.setLargura_pro(20.000);
	    produto16.setComprimento_pro(20.000);
	    produto16.setDiametro_pro(20.000);
	    // Histórico
	    produto16.setCreated_at(cal.getTime());
		produto16.setUpdated_at(cal.getTime());
	    produto16.setDeleted_at(null);
	    produto16.setDeleted(false);
		
		
		
	    /*
	     * 
	     * Imagem
	     * 
	     */
	    
	    Imagem imagem1 = new Imagem();
	    imagem1.setArquivo_ima("01.jpg");
	    imagem1.setOrdem_ima(1);
	    Imagem imagem2 = new Imagem();
	    imagem2.setArquivo_ima("02.jpg");
	    imagem2.setOrdem_ima(2);
	    Imagem imagem3 = new Imagem();
	    imagem3.setArquivo_ima("03.jpg");
	    imagem3.setOrdem_ima(3);
	    Imagem imagem4 = new Imagem();
	    imagem4.setArquivo_ima("04.jpg");
	    imagem4.setOrdem_ima(4);
	    Imagem imagem5 = new Imagem();
	    imagem5.setArquivo_ima("05.jpg");
	    imagem5.setOrdem_ima(5);
	    Imagem imagem6 = new Imagem();
	    imagem6.setArquivo_ima("06.jpg");
	    imagem6.setOrdem_ima(6);
	    Imagem imagem7 = new Imagem();
	    imagem7.setArquivo_ima("07.jpg");
	    imagem7.setOrdem_ima(1);
	    Imagem imagem8 = new Imagem();
	    imagem8.setArquivo_ima("08.jpg");
	    imagem8.setOrdem_ima(2);
	    Imagem imagem9 = new Imagem();
	    imagem9.setArquivo_ima("09.jpg");
	    imagem9.setOrdem_ima(1);
	    Imagem imagem10 = new Imagem();
	    imagem10.setArquivo_ima("10.jpg");
	    imagem10.setOrdem_ima(2);
	    Imagem imagem11 = new Imagem();
	    imagem11.setArquivo_ima("11.jpg");
	    imagem11.setOrdem_ima(1);
	    Imagem imagem12 = new Imagem();
	    imagem12.setArquivo_ima("12.jpg");
	    imagem12.setOrdem_ima(2);
	    Imagem imagem13 = new Imagem();
	    imagem13.setArquivo_ima("13.jpg");
	    imagem13.setOrdem_ima(1);
	    Imagem imagem14 = new Imagem();
	    imagem14.setArquivo_ima("14.jpg");
	    imagem14.setOrdem_ima(2);
	    Imagem imagem15 = new Imagem();
	    imagem15.setArquivo_ima("15.jpg");
	    imagem15.setOrdem_ima(1);
	    Imagem imagem16 = new Imagem();
	    imagem16.setArquivo_ima("16.jpg");
	    imagem16.setOrdem_ima(2);
	    Imagem imagem17 = new Imagem();
	    imagem17.setArquivo_ima("17.jpg");
	    imagem17.setOrdem_ima(1);
	    Imagem imagem18 = new Imagem();
	    imagem18.setArquivo_ima("18.jpg");
	    imagem18.setOrdem_ima(2);
	    Imagem imagem19 = new Imagem();
	    imagem19.setArquivo_ima("19.jpg");
	    imagem19.setOrdem_ima(1);
	    Imagem imagem20 = new Imagem();
	    imagem20.setArquivo_ima("20.jpg");
	    imagem20.setOrdem_ima(2);
	    Imagem imagem21 = new Imagem();
	    imagem21.setArquivo_ima("21.jpg");
	    imagem21.setOrdem_ima(1);
	    Imagem imagem22 = new Imagem();
	    imagem22.setArquivo_ima("22.jpg");
	    imagem22.setOrdem_ima(2);
	    Imagem imagem23 = new Imagem();
	    imagem23.setArquivo_ima("23.jpg");
	    imagem23.setOrdem_ima(1);
	    Imagem imagem24 = new Imagem();
	    imagem24.setArquivo_ima("24.jpg");
	    imagem24.setOrdem_ima(2);
	    Imagem imagem25 = new Imagem();
	    imagem25.setArquivo_ima("25.jpg");
	    imagem25.setOrdem_ima(1);
	    Imagem imagem26 = new Imagem();
	    imagem26.setArquivo_ima("26.jpg");
	    imagem26.setOrdem_ima(2);
	    Imagem imagem27 = new Imagem();
	    imagem27.setArquivo_ima("27.jpg");
	    imagem27.setOrdem_ima(1);
	    Imagem imagem28 = new Imagem();
	    imagem28.setArquivo_ima("28.jpg");
	    imagem28.setOrdem_ima(2);
	    Imagem imagem29 = new Imagem();
	    imagem29.setArquivo_ima("29.jpg");
	    imagem29.setOrdem_ima(1);
	    Imagem imagem30 = new Imagem();
	    imagem30.setArquivo_ima("30.jpg");
	    imagem30.setOrdem_ima(2);
	    Imagem imagem31 = new Imagem();
	    imagem31.setArquivo_ima("31.jpg");
	    imagem31.setOrdem_ima(1);
	    Imagem imagem32 = new Imagem();
	    imagem32.setArquivo_ima("32.jpg");
	    imagem32.setOrdem_ima(2);
	    Imagem imagem33 = new Imagem();
	    imagem33.setArquivo_ima("33.jpg");
	    imagem33.setOrdem_ima(1);
	    Imagem imagem34 = new Imagem();
	    imagem34.setArquivo_ima("34.jpg");
	    imagem34.setOrdem_ima(2);
	    Imagem imagem35 = new Imagem();
	    imagem35.setArquivo_ima("35.jpg");
	    imagem35.setOrdem_ima(1);
	    Imagem imagem36 = new Imagem();
	    imagem36.setArquivo_ima("36.jpg");
	    imagem36.setOrdem_ima(2);
	    Imagem imagem37 = new Imagem();
	    imagem37.setArquivo_ima("37.jpg");
	    imagem37.setOrdem_ima(1);
	    Imagem imagem38 = new Imagem();
	    imagem38.setArquivo_ima("38.jpg");
	    imagem38.setOrdem_ima(2);
	    
		/*
		 * 
		 * Banner
		 * 
		 */
	    
	    Banner banner = new Banner();
	    
	    banner.setArquivo_ban("banner.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
		
	    Banner banner1 = new Banner();
	    
	    banner.setArquivo_ban("banner1.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
		
		Banner banner2 = new Banner();
	    
	    banner.setArquivo_ban("banner2.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
		
		Banner banner3 = new Banner();
	    
	    banner.setArquivo_ban("banner3.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
		
		Banner banner4 = new Banner();
	    
	    banner.setArquivo_ban("banner4.jpg");
	    banner.setAtivo_ban(true);
	    // Histórico
	    produto.setCreated_at(cal.getTime());
		produto.setUpdated_at(cal.getTime());
	    produto.setDeleted_at(null);
	    produto.setDeleted(false);
		
		
		
	    /*
	     * 
	     * Fornecedor
	     * 
	     */
	    
	    Fornecedor fornecedor = new Fornecedor();

	    fornecedor.setNome_for("Pentágono");
	    fornecedor.setLogo_for("01.jpg");
	    fornecedor.setEmail_for("pentagono.edu@gmail.com");
	    fornecedor.setCnpj_for("36.686.772/0001-76");
	    fornecedor.setCep_for("09132-190");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Osvaldo Orico");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 32136636");
		
		Fornecedor fornecedor1 = new Fornecedor();

	    fornecedor.setNome_for("Armazem do vidro");
	    fornecedor.setLogo_for("logo2.jpg");
	    fornecedor.setEmail_for("armazemdovidro@hotmail.com");
	    fornecedor.setCnpj_for("37.886.872/0001-86");
	    fornecedor.setCep_for("09534-290");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Cruz e Souza");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 48136586");
		
		Fornecedor fornecedor2 = new Fornecedor();

	    fornecedor.setNome_for("Fedex");
	    fornecedor.setLogo_for("logo3.jpg");
	    fornecedor.setEmail_for("fedex@fedex.com");
	    fornecedor.setCnpj_for("39.996.856/0001-56");
	    fornecedor.setCep_for("09658-250");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Francisco");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 25687563");
		
		Fornecedor fornecedor3 = new Fornecedor();

	    fornecedor.setNome_for("Padaria União");
	    fornecedor.setLogo_for("logo4.jpg");
	    fornecedor.setEmail_for("padariauniao@gmail.com");
	    fornecedor.setCnpj_for("45.789.772/0002-86");
	    fornecedor.setCep_for("09584-510");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Teotonio Vilela");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 24516328");
		
		Fornecedor fornecedor4 = new Fornecedor();

	    fornecedor.setNome_for("Franklin");
	    fornecedor.setLogo_for("logo5.jpg");
	    fornecedor.setEmail_for("Flanklin@hotmail.com");
	    fornecedor.setCnpj_for("46.985.564/0001-96");
	    fornecedor.setCep_for("09132-190");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Matarazo");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 446156596");
		
		Fornecedor fornecedor5 = new Fornecedor();

	    fornecedor.setNome_for("Remodeling");
	    fornecedor.setLogo_for("logo1.jpg");
	    fornecedor.setEmail_for("remodeling@gmail.com");
	    fornecedor.setCnpj_for("56.554.254/0001-24");
	    fornecedor.setCep_for("08541-250");
	    fornecedor.setEstado_for("SP");
	    fornecedor.setCidade_for("São Paulo");
	    fornecedor.setEndereco_for("Rua Epitacio Pessoa");
	    fornecedor.setComplemento_for("");
	    fornecedor.setComercial_for("11 42589635");
		
		
	    // Histórico
	    fornecedor.setCreated_at(cal.getTime());
		fornecedor.setUpdated_at(cal.getTime());
	    fornecedor.setDeleted_at(null);
	    fornecedor.setDeleted(false);
	    
	    /*
	     * 
	     * Produto do Fornecedor
	     * 
	     */
	    
	    Produto_has_fornecedor prod_forn = new Produto_has_fornecedor();
	    prod_forn.setPreco_prod(100.00);
	    prod_forn.setQuantidade_prod(100);

	    /*
	     * Injetar
	     */
	    
	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("produtos");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();
	    // Cargos e permissoes
	    manager.persist(cargo);
	    manager.flush();
	    permissao.setCargo(cargo);
	    manager.persist(permissao);
	    
	    manager.persist(cargo1);
	    manager.flush();
	    permissao1.setCargo(cargo1);
	    manager.persist(permissao1);
	    System.out.println("ID da permissao: " + permissao1.getId_permissao());

	    // Funcionarios
	    funcionario.setCargo(cargo);
	    funcionario1.setCargo(cargo);
	    funcionario2.setCargo(cargo1);
	    funcionario3.setCargo(cargo1);
	    manager.persist(funcionario);
	    manager.persist(funcionario1);
	    manager.persist(funcionario2);
	    manager.persist(funcionario3);
	    System.out.println("ID do funcionario: " + funcionario.getId_funcionario());
	    
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da permissao: " + permissao.getId_permissao());
	    System.out.println("ID do cargo: " + cargo.getId_cargo());
	    System.out.println("ID do funcionario: " + funcionario.getId_funcionario());
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("-------------------------------------------------"+funcionario.getSenha_fun());
	    
	    manager.persist(celular);
	    manager.flush();
	    manager.persist(eletronico);
	    manager.flush();
	    manager.persist(games);
	    manager.flush();
	    manager.persist(acessorios);
	    manager.flush();
	    
	    produto.setCategoria(celular);
	    produto1.setCategoria(celular);
	    produto2.setCategoria(celular);
	    produto3.setCategoria(celular);
	    produto4.setCategoria(eletronico);
	    produto5.setCategoria(eletronico);
	    produto6.setCategoria(eletronico);
	    produto7.setCategoria(eletronico);
	    produto8.setCategoria(games);
	    produto9.setCategoria(games);
	    produto10.setCategoria(games);
	    produto11.setCategoria(games);
	    produto12.setCategoria(acessorios);
	    produto13.setCategoria(acessorios);
	    produto14.setCategoria(acessorios);
	    produto15.setCategoria(acessorios);
	    produto16.setCategoria(celular);
	    // Produtos e Imagens
	    manager.persist(produto);
	    manager.flush();
	    manager.persist(produto1);
	    manager.flush();
	    manager.persist(produto2);
	    manager.flush();
	    manager.persist(produto3);
	    manager.flush();
	    manager.persist(produto4);
	    manager.flush();
	    manager.persist(produto5);
	    manager.flush();
	    manager.persist(produto6);
	    manager.flush();
	    manager.persist(produto7);
	    manager.flush();
	    manager.persist(produto8);
	    manager.flush();
	    manager.persist(produto9);
	    manager.flush();
	    manager.persist(produto10);
	    manager.flush();
	    manager.persist(produto11);
	    manager.flush();
	    manager.persist(produto12);
	    manager.flush();
	    manager.persist(produto13);
	    manager.flush();
	    manager.persist(produto14);
	    manager.flush();
	    manager.persist(produto15);
	    manager.flush();
	    manager.persist(produto16);
	    manager.flush();
	    
	    imagem1.setProduto(produto);
	    imagem2.setProduto(produto);
	    imagem3.setProduto(produto);
	    imagem4.setProduto(produto);
	    imagem5.setProduto(produto);
	    imagem6.setProduto(produto);
	    manager.persist(imagem1);
	    manager.persist(imagem2);
	    manager.persist(imagem3);
	    manager.persist(imagem4);
	    manager.persist(imagem5);
	    manager.persist(imagem6);
	    imagem7.setProduto(produto1);
	    imagem8.setProduto(produto1);
	    imagem9.setProduto(produto2);
	    imagem10.setProduto(produto2);
	    imagem11.setProduto(produto3);
	    imagem12.setProduto(produto3);
	    imagem13.setProduto(produto4);
	    imagem14.setProduto(produto4);
	    imagem15.setProduto(produto5);
	    imagem16.setProduto(produto5);
	    imagem17.setProduto(produto6);
	    imagem18.setProduto(produto6);
	    imagem19.setProduto(produto7);
	    imagem20.setProduto(produto7);
	    imagem21.setProduto(produto8);
	    imagem22.setProduto(produto8);
	    imagem23.setProduto(produto9);
	    imagem24.setProduto(produto9);
	    imagem25.setProduto(produto10);
	    imagem26.setProduto(produto10);
	    imagem27.setProduto(produto11);
	    imagem28.setProduto(produto11);
	    imagem29.setProduto(produto12);
	    imagem30.setProduto(produto12);
	    imagem31.setProduto(produto13);
	    imagem32.setProduto(produto13);
	    imagem33.setProduto(produto14);
	    imagem34.setProduto(produto14);
	    imagem35.setProduto(produto15);
	    imagem36.setProduto(produto15);
	    imagem37.setProduto(produto16);
	    imagem38.setProduto(produto16);
	    
	    banner.setProduto(produto);
	    banner1.setProduto(produto1);
	    banner2.setProduto(produto2);
	    banner3.setProduto(produto3);
	    banner4.setProduto(produto4);
	    manager.persist(banner);
	    manager.persist(banner1);
	    manager.persist(banner2);
	    manager.persist(banner3);
	    manager.persist(banner4);

	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da categoria: " + celular.getId_categoria());
	    System.out.println("ID do produto: " + produto.getId_produto());
	    System.out.println("ID da imagem: " + imagem1.getId_imagem());
	    System.out.println("ID da imagem: " + imagem2.getId_imagem());
	    System.out.println("ID da imagem: " + imagem3.getId_imagem());
	    System.out.println("ID da imagem: " + imagem4.getId_imagem());
	    System.out.println("ID da imagem: " + imagem5.getId_imagem());
	    System.out.println("ID da imagem: " + imagem6.getId_imagem());
	    System.out.println("ID do banner: " + banner.getId_banner());
	    System.out.println("--------------------------------------------------------------------------");
	    
	    manager.persist(fornecedor);
	    manager.flush();
	    manager.persist(fornecedor1);
	    manager.flush();
	    manager.persist(fornecedor2);
	    manager.flush();
	    manager.persist(fornecedor3);
	    manager.flush();
	    manager.persist(fornecedor4);
	    manager.flush();
	    manager.persist(fornecedor5);
	    manager.flush();
	    
	    prod_forn.setFornecedor(fornecedor);
	    prod_forn.setProduto(produto);
	    manager.persist(prod_forn);
	    manager.getTransaction().commit();  

	    manager.close();
	  }
}
