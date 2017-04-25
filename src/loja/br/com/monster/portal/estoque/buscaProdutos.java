package br.com.monster.portal.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.modelDao.ProdutoDao;
import br.com.monster.portal.model.Produto;

@Transactional
@Controller
public class buscaProdutos {
	
	@Autowired
	ProdutoDao dao;
	
	/*
	 *==============================
	 * 			Produto				
	 *==============================
	 */
	
	@RequestMapping("index")
	public String Index (Model model, String nome_prod, Produto produto) {
		model.addAttribute("produtos", dao.Find_produto(nome_prod));
		return "Index";
		
	}
	
	
}
