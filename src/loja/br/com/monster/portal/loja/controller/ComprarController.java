package br.com.monster.portal.loja.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.PedidoDao;
import br.com.monster.portal.modelDao.ProdutoDao;

@Transactional
@Controller
public class ComprarController {
	
	@Autowired
	CategoriaDao dao_cat;
	
	@Autowired
	ProdutoDao dao_prod;
	
	@Autowired
	PedidoDao dao_ped;

	/*
	 *==============================
	 * 		COMPRA e Pagamento	
	 *==============================
	 */
	
	@RequestMapping(value = "/Pagamento/{nome_produto}")
	public String Pagamento(Model model, @PathVariable("nome_produto") String nome_produto, Produto produto) {
		model.addAttribute("produtos", dao_prod.Find_publico(nome_produto));
		model.addAttribute("categorias", dao_cat.Read());
		return "Pagamento";
	}
	
	
	
	
	
	
	// Produto produto, PARA TESTAR
	// Set<Produto> produto,
	
	@RequestMapping(value = "/Comprar_um")
	public String Comprar_um(Model model, @Valid Pedido pedido, Produto produto, BindingResult result) {
		//	Cabeçalho
		model.addAttribute("categorias", dao_cat.Read());

		// Gerar numero randomico
		int min = 100000000;//na vdd são 14 campos
		int max = 999999999;
		String numb_ped = "00000.00000  00000.000000  00000.000000  0  "+ThreadLocalRandom.current().nextInt(min, max + 1);
		
		long teste;
		
		if(result.hasErrors()) {
			// EM TESTE
		    return "forward:Pagamento/1";
		} else {
			dao_ped.create(pedido);
			model.addAttribute("numb_ped", numb_ped);
			return "redirect:Boleto";
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("Boleto")
	public String Boleto(Model model) {
		model.addAttribute("categorias", dao_cat.Read());
		return "Boleto";
	}
	
	@RequestMapping(value = "Imprimir_Boleto")
	public String Imprimir_Boleto(Model model, Pedido pedido, HttpServletRequest request, HttpServletResponse response) {
		String numb_ped = request.getParameter("numb_ped");
		model.addAttribute("pedidos", dao_ped.Find_pedido_boleto(numb_ped));
		return "Imprimir_Boleto";
	}
	
}
