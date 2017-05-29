package br.com.monster.portal.loja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.frete.Frete;
import br.com.monster.portal.frete.ListaFrete;
import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;
import br.com.monster.portal.modelDao.BannerDao;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ProdutoDao;
import br.com.monster.portal.modelDao.Produto_has_fornecedorDao;

@Transactional
@Controller
public class PagesController {

	@Autowired
	BannerDao dao_ban;
	
	//						-- Provisório --
	// Implementado para passar as categorias pro header da página
	@Autowired
	CategoriaDao dao_cat;
	
	@Autowired
	ProdutoDao dao_prod;
	
	@Autowired
	Produto_has_fornecedorDao prod_forn_dao;
	
	@RequestMapping("index")
	public String Home(Model model) {
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		model.addAttribute("banners", dao_ban.Read_publico());
		model.addAttribute("produtos", dao_prod.read_destacado());
		return "index";
	}

	/*
	 *==============================
	 * 		M�todos de procura		
	 *==============================
	 */
	
	@RequestMapping("/Procurar")
	public String Find(Model model, Produto produto, HttpServletRequest request) {
		String nome_prod = request.getParameter("nome_prod");

		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		model.addAttribute("produtos", dao_prod.findByName(nome_prod));
		return "Procurar";
	}
	
	@RequestMapping(value = "/Categoria/{id}")
	public String Find_Categoria(Model model, @PathVariable ("id") Long id){
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		model.addAttribute("produtos", dao_prod.find_produto_cat(id));
	    return "Categoria";
	}

	@RequestMapping(value = "/Produtos/{id}")
	public String Find_Produto(Model model, @PathVariable("id") Long id, HttpSession session){
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		
		Produto_has_fornecedor prod_forn = (Produto_has_fornecedor) prod_forn_dao.findOnePublic(id);
		Produto produto = prod_forn.getProduto();
		Fornecedor fornecedor = prod_forn.getFornecedor();
		
		model.addAttribute("produto", produto);
		model.addAttribute("fornecedor", fornecedor);
		model.addAttribute("prod_forn", prod_forn);
		
		Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
		if(cliente != null){
			if(cliente.getCep_cli() != null){
				ListaFrete frete = Frete.consultaFrete(cliente, fornecedor, produto);
				model.addAttribute("frete", frete);
			}
		}
	    return "Escolha";
	}

	/*
	 *==============================
	 * 			Outros				
	 *==============================
	 */
	
	@RequestMapping("Contato")
	public String Contato(Model model) {
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		return "Contato";
	}
}
