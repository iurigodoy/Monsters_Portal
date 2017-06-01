package br.com.monster.portal.loja.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.carrinho.Carrinho;
import br.com.monster.portal.carrinho.Item;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.Produto_has_fornecedorDao;

@Transactional
@Controller
public class CarrinhoController {
	
	@Autowired
	CategoriaDao dao_cat;

	@Autowired
	Produto_has_fornecedorDao dao;
	
	@Autowired
	Carrinho carrinho;

	@RequestMapping("AdicionaItemCarrinho")
	public String adiciona(Long id_prod, Long id_forn, Item item, HttpSession session) {
		item.setProduto_has_fornecedor(dao.recarrega(id_prod, id_forn));
		carrinho.adiciona(item);
		carrinho.frete(session, item);
		session.setAttribute("carrinho", carrinho);

		return "redirect:carrinho";
	}

	@RequestMapping("carrinho")
	public String carrinho(Model model) {
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		return "carrinho";
	}

	@RequestMapping("RemoveItemCarrinho")
	public String remove(int indiceItem, HttpSession session) {
	    carrinho.remove(indiceItem);
	    session.setAttribute("carrinho", carrinho);
		return "redirect:carrinho";
	}

}
