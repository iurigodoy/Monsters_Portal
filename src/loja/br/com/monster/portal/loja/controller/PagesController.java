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
import br.com.monster.portal.modelDao.BannerDao;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ProdutoDao;

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
	public String Find(Model model, Produto produto, HttpServletRequest request, HttpServletResponse response) {
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
	public String Find_Produto(Model model, @PathVariable("id") Long id, Produto produto){
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		
		produto = (Produto) dao_prod.findOnePublic(id);
		model.addAttribute("produtos", produto);
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
