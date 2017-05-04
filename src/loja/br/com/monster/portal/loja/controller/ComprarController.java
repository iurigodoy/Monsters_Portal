package br.com.monster.portal.loja.controller;

import java.util.concurrent.ThreadLocalRandom;

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

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.PedidoDao;
import br.com.monster.portal.modelDao.ProdutoDao;
import br.com.monster.portal.carrinho.Carrinho;

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
	
<<<<<<< HEAD
	@RequestMapping(value = "/forma_de_pagamento")
	public String pagamento(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "forma_de_pagamento";
	}
	
	@RequestMapping(value = "/boleto")
	public String boleto(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "confirmar_dados_boleto";
=======
	@RequestMapping(value = "/Pagamento/{nome_produto}")
	public String Pagamento(Model model, @PathVariable("nome_produto") String nome_produto, Produto produto) {
		model.addAttribute("produtos", dao_prod.Find_publico(nome_produto));
		model.addAttribute("categorias", dao_cat.Read());
		return "Pagamento";
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
	}
	
	
	
	
	
	
	// Produto produto, PARA TESTAR
	// Set<Produto> produto,
	
<<<<<<< HEAD
	@RequestMapping(value = "/FinalizarCompraSeguraComBoleto")
	public String comprarComBoleto(Model model, @Valid Pedido pedido,
			BindingResult result, HttpSession session, Carrinho carrinho) {
		
		model.addAttribute("categorias", dao_cat.read()); //	CabeÁalho
		
		carrinho = (Carrinho) session.getAttribute("carrinho");
		
		Double precoTotalProdutos = carrinho.getTotal();
=======
	@RequestMapping(value = "/Comprar_um")
	public String Comprar_um(Model model, @Valid Pedido pedido, Produto produto, BindingResult result) {
		//	CabeÁalho
		model.addAttribute("categorias", dao_cat.Read());
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado

		// Gerar numero randomico
		int min = 100000000;//na vdd s„o 14 campos
		int max = 999999999;
		String numb_ped = "00000.00000  00000.000000  00000.000000  0  "+ThreadLocalRandom.current().nextInt(min, max + 1);
		
		long teste;
		
		if(result.hasErrors()) {
			// EM TESTE
		    return "forward:Pagamento/1";
		} else {
<<<<<<< HEAD
			//dao_ped.create(pedido, produtos);
			//model.addAttribute("numb_ped", numb_ped);
=======
			dao_ped.create(pedido);
			model.addAttribute("numb_ped", numb_ped);
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
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
