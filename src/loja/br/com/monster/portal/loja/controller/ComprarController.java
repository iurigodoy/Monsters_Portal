package br.com.monster.portal.loja.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.carrinho.Carrinho;
import br.com.monster.portal.model.Cliente;
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
	PedidoDao dao;

	/*
	 *==============================
	 * 		COMPRA e Pagamento	
	 *==============================
	 */
	
	@RequestMapping(value = "/checarIdentificacao")
	public String checarIdentificacao(HttpSession session) {
		if(session.getAttribute("clienteLogado") != null)
			return "redirect:forma_de_pagamento";
		else
			return "redirect:identificacao";
	}
	
	@RequestMapping(value = "/identificacao")
	public String identificacao(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "identificacao/identificacao";
	}
	
	@RequestMapping(value = "/forma_de_pagamento")
	public String formaDePagamento(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "comprar/forma_de_pagamento";
	}
	
	
	
	
	
	@RequestMapping(value = "/FinalizarCompraSegura")
	public String comprar(Model model, @Valid Pedido pedido, HttpSession session, BindingResult result) {
		
		Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
		Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
		
		// Gerar numero randomico
		int min = 100000000;//na vdd s�o 14 campos
		int max = 999999999;
		int numb_ped = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		pedido.setNumero_ped(numb_ped);
		
		if(result.hasErrors()) {
			// EM TESTE
		    return "forward:forma_de_pagamento";
		} else {
			Long id = dao.create(pedido, carrinho, cliente);
			return "redirect:boleto/"+id;
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/boleto/{id}")
	public String Boleto(Model model, @PathVariable ("id") Long id) {
		model.addAttribute("categorias", dao_cat.read());
		model.addAttribute("pedido", dao.findOne(id));
		return "comprar/boleto";
	}
	
	@RequestMapping("/imprimir_boleto/{id}")
	public String Imprimir_Boleto(Model model, @PathVariable ("id") Long id, Pedido pedido) {
		model.addAttribute("pedido", dao.findOneNoPay(id));
		return "comprar/imprimirBoleto";
	}
	
}
