package br.com.monster.portal.loja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.ListaProduto;
import br.com.monster.portal.model.Pedido;
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
	
	@RequestMapping(value = "/checarIdentificacao")
	public String checarIdentificacao(HttpSession session) {
		if(session.getAttribute("clienteLogado") != null)
			return "redirect:forma_pagamento";
		else
			return "redirect:identificacao";
	}
	
	@RequestMapping(value = "/identificacao")
	public String identificacao(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "comprar/identificacao";
	}
	
	@RequestMapping(value = "/comprar_agora")
	public String comprarAgora(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "comprar/cadastroComprarAgora";
	}
	
	@RequestMapping(value = "/CadastroComprarAgora")
	public String cadastroComprarAgora(Model model, HttpSession session, Cliente cliente) {
		model.addAttribute("categorias", dao_cat.read());
		session.setAttribute("clienteLogado", cliente);
		return "redirect:forma_de_pagamento";
	}
	
	@RequestMapping(value = "/forma_de_pagamento")
	public String formaDePagamento(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "comprar/forma_de_pagamento";
	}
	
	
	
	
	
	
	// Produto produto, PARA TESTAR
	// Set<Produto> produto,
	
	@RequestMapping(value = "/FinalizarCompraSegura")
	public String comprar(Model model, @Valid Pedido pedido, ListaProduto produtos, BindingResult result) {
		//	Cabe�alho
		model.addAttribute("categorias", dao_cat.read());

		// Gerar numero randomico
		//int min = 100000000;//na vdd s�o 14 campos
		//int max = 999999999;
		//String numb_ped = "00000.00000  00000.000000  00000.000000  0  "+ThreadLocalRandom.current().nextInt(min, max + 1);
		
		long teste;
		
		if(result.hasErrors()) {
			// EM TESTE
		    return "forward:forma_de_pagamento";
		} else {
			dao_ped.create(pedido, produtos);
			//model.addAttribute("numb_ped", numb_ped);
			return "redirect:boleto";
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("boleto")
	public String Boleto(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "comprar/boleto";
	}
	
	@RequestMapping(value = "Imprimir_Boleto")
	public String Imprimir_Boleto(Model model, Pedido pedido, HttpServletRequest request, HttpServletResponse response) {
		String numb_ped = request.getParameter("numb_ped");
		model.addAttribute("pedidos", dao_ped.Find_pedido_boleto(numb_ped));
		return "comprar/Imprimir_Boleto";
	}
	
}
