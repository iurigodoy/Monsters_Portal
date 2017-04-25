package br.com.monster.portal.adm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.FornecedorDao;
import br.com.monster.portal.modelDao.ProdutoDao;

@Transactional
@Controller
public class ProdutoController {

	@Autowired
	ProdutoDao dao;
	
	@Autowired
	CategoriaDao cat_dao;

	@Autowired
	FornecedorDao forc_dao;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Add_Produto")
	public String create_page(Model model) {
		model.addAttribute("produtos", dao.read());
		model.addAttribute("fornecedores", forc_dao.read());
		model.addAttribute("categorias", cat_dao.read());
		return "admin/Produto/adicionar";
	}
	
	@RequestMapping("Admin/CreateProduto")
	public String create(@Valid Produto produto, ImagemMultiple imagens, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Produto";
		} else {
			dao.create(produto, imagens);
			return "redirect:Add_Produto";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Produto")
	public String Read(Model model) {
		model.addAttribute("produtos", dao.read());
		return "admin/Produto/visualizar";
	}
	
	@RequestMapping("Admin/Produto_loja")
	public String Read_page_store(Model model) {
		model.addAttribute("produtos", dao.read());
		return "admin/Produto/visualizar";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateProduto")
	public String update(@Valid Produto produto, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Produto";
		} else {
			dao.update(produto);
			return "redirect:Produto";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteProduto")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Produto";
	} 
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreProduto")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarProduto")
	public String Find(Model model, Produto produto,
			 HttpServletRequest request, HttpServletResponse response) {
		
		String nome_prod = request.getParameter("nome_prod");
		model.addAttribute("prod_page", "active");
		model.addAttribute("produtos", dao.Find_By_Name(nome_prod));
		model.addAttribute("fornecedores", forc_dao.read());
		model.addAttribute("categorias", cat_dao.read());
		return "admin/Produto";
	}
	
}
