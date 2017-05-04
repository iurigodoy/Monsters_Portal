package br.com.monster.portal.loja.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;
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
	public String Find(Model model, Produto produto, HttpServletRequest request) {
		String nome_prod = request.getParameter("nome_prod");

		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		model.addAttribute("produtos", dao_prod.Find_Many_publico(nome_prod));
		return "Procurar";
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/Categoria/{id}")
	public String Find_Categoria(Model model, @PathVariable ("id") Long id){
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		model.addAttribute("produtos", dao_prod.FindProdutoPorCategoria(id));
	    return "Categoria";
	}

	@RequestMapping(value = "/Produtos/{id}")
	public String Find_Produto(Model model, @PathVariable("id") Long id){
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		
		Produto_has_fornecedor prodf = dao_prod.findOnePublic(id);
		model.addAttribute("produto", prodf.getProduto());
		model.addAttribute("prod_forn", prodf);
=======
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
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
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
