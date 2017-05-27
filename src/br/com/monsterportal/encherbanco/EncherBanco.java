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
		
		Cargo cargo = new Cargo();

		cargo.setNome_car("Super Usuário");
		cargo.setPadrao_car(false);
	    cargo.setCreated_at(cal.getTime());
		cargo.setUpdated_at(cal.getTime());
	    cargo.setDeleted_at(null);
	    cargo.setDeleted(false);
		
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
	    // Histórico
	    funcionario.setCreated_at(cal.getTime());
		funcionario.setUpdated_at(cal.getTime());
	    funcionario.setDeleted_at(null);
	    funcionario.setDeleted(false);

		/*
		 * 
		 * Categoria
		 * 
		 */
		
		Categoria categoria = new Categoria();
		categoria.setNome_cat("celular");
		categoria.setHierarquia_cat(0);
	    // Histórico
	    categoria.setCreated_at(cal.getTime());
		categoria.setUpdated_at(cal.getTime());
	    categoria.setDeleted_at(null);
	    categoria.setDeleted(false);
	    
		/*
		 * 
		 * Produto
		 * 
		 */
	    
	    Produto produto = new Produto();
	    
	    produto.setNome_pro("Samsung test");
	    produto.setDescricao_pro("testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	    produto.setCategoria(categoria);
	    // MKT
	    produto.setPromocao_pro(true);
	    produto.setPublicado_pro(true);
	    produto.setDesconto_pro(0.10);
	    produto.setDestaque_pro(false);
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
	    
		/*
		 * 
		 * Banner
		 * 
		 */
	    
	    Banner banner = new Banner();
	    
	    banner.setArquivo_ban("02.jpg");
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

	    manager.persist(cargo);
	    manager.flush();
	    permissao.setCargo(cargo);
	    manager.persist(permissao);
	    manager.flush();
	    funcionario.setCargo(cargo);
	    manager.persist(funcionario);
	    
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da permissao: " + permissao.getId_permissao());
	    System.out.println("ID do cargo: " + cargo.getId_cargo());
	    System.out.println("ID do funcionario: " + funcionario.getId_funcionario());
	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("-------------------------------------------------"+funcionario.getSenha_fun());
	    
	    manager.persist(categoria);
	    manager.flush();
	    produto.setCategoria(categoria);
	    manager.persist(produto);
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
	    manager.persist(banner);

	    System.out.println("--------------------------------------------------------------------------");
	    System.out.println("ID da categoria: " + categoria.getId_categoria());
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
	    prod_forn.setFornecedor(fornecedor);
	    prod_forn.setProduto(produto);
	    manager.persist(prod_forn);
	    manager.getTransaction().commit();  

	    manager.close();
	  }
}
