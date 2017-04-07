package br.com.monster.portal.carrinho;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.modelDao.Produto_has_fornecedorDao;

@Transactional
@Controller
public class CarrinhoController {

	@Autowired
	Produto_has_fornecedorDao dao;
	@Autowired
	Carrinho carrinho;

	@RequestMapping("AdicionaItemCarrinho")
	public String adiciona(Long id_prod, Long id_forn, Item item, HttpSession session) {
		item.setProduto_has_fornecedor(dao.recarrega(id_prod, id_forn));
		carrinho.adiciona(item);
		session.setAttribute("carrinho", carrinho);

		return "redirect:carrinho";
	}

	@RequestMapping("carrinho")
	public String visualiza() {
		return "carrinho";
	}

	@RequestMapping("RemoveItemCarrinho")
	public String remove(int indiceItem, HttpSession session) {
	    carrinho.remove(indiceItem);
	    session.setAttribute("carrinho", carrinho);
		return "redirect:carrinho";
	}

}
