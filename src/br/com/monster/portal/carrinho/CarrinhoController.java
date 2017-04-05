package br.com.monster.portal.carrinho;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarrinhoController {

	@RequestMapping("AdicionaItemCarrinho")
	public String adiciona(Item item, Carrinho carrinho, HttpSession session) {
	    carrinho.adiciona(item);
	    session.setAttribute("carrinho", carrinho);

	    return "redirect:carrinho";
	}

	@RequestMapping("carrinho")
	public String visualiza() {
		return "carrinho";
	}

	@RequestMapping("RemoveItemCarrinho")
	public String remove(int indiceItem, Carrinho carrinho, HttpSession session) {
	    carrinho.remove(indiceItem);
	    session.setAttribute("carrinho", carrinho);
	    return "redirect:carrinho";
	}

}
