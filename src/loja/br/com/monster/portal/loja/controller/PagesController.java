package br.com.monster.portal.loja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.AvaliacaoDao;
import br.com.monster.portal.modelDao.BannerDao;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ProdutoDao;

@Transactional
@Controller
public class PagesController {

	@Autowired
	BannerDao dao_ban;
	
	@Autowired
	AvaliacaoDao dao_ava;
	
	//						-- Provisório --
	// Implementado para passar as categorias pro header da página
	@Autowired
	CategoriaDao dao_cat;
	
	@Autowired
	ProdutoDao dao_prod;
	
	@RequestMapping("index")
	public String Home(Model model) {
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		model.addAttribute("banners", dao_ban.Read_publico());
		model.addAttribute("produtos", dao_prod.Read_destacado());
		return "index";
	}
	
	/*
	 *==============================
	 * 		M�todos de procura		
	 *==============================
	 */
	
	@RequestMapping("/Procurar")
	public String Find(Model model, Produto produto, HttpServletRequest request, HttpServletResponse response) {
		String nome_prod = request.getParameter("nome_prod");

		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		model.addAttribute("produtos", dao_prod.Find_Many_publico(nome_prod));
		return "Procurar";
	}
	
	@RequestMapping(value = "/Categoria/{nome_categoria}")
	public String Find_Categoria(Model model, @PathVariable ("nome_categoria") String nome_categoria, Categoria categoria){
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		model.addAttribute("categorias1", dao_cat.Find_produto_cat(nome_categoria, categoria));
	    return "Categoria";
	}

	@RequestMapping(value = "/Produtos/{nome_produto}")
	public String Find_Produto(Model model, @PathVariable("nome_produto") String nome_produto, Produto produto){
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		
		produto = (Produto) dao_prod.Find_publico(nome_produto);
		model.addAttribute("produtos", produto);
		model.addAttribute("avaliacoes", dao_ava.read(produto));
	    return "Escolha";
	}

	/*
	 *==============================
	 * 			Outros				
	 *==============================
	 */
	
	@RequestMapping("Contato")
	public String Contato(Model model) {
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		return "Contato";
	}
}
