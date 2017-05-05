package br.com.monster.portal.loja.controller;

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

import br.com.monster.portal.model.ListaProduto;
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
	
	@RequestMapping(value = "/Pagamento/{id}")
	public String Pagamento(Model model, @PathVariable("id") Long id, Produto produto) {
		model.addAttribute("produtos", dao_prod.findOnePublic(id));
		model.addAttribute("categorias", dao_cat.read());
		return "Pagamento";
	}
	
	
	
	
	
	
	// Produto produto, PARA TESTAR
	// Set<Produto> produto,
	
	@RequestMapping(value = "/FinalizarCompraSegura")
	public String comprar(Model model, @Valid Pedido pedido, ListaProduto produtos, BindingResult result) {
		//	Cabeçalho
		model.addAttribute("categorias", dao_cat.read());

		// Gerar numero randomico
		//int min = 100000000;//na vdd são 14 campos
		//int max = 999999999;
		//String numb_ped = "00000.00000  00000.000000  00000.000000  0  "+ThreadLocalRandom.current().nextInt(min, max + 1);
		
		long teste;
		
		if(result.hasErrors()) {
			// EM TESTE
		    return "forward:Pagamento/1";
		} else {
			dao_ped.create(pedido, produtos);
			//model.addAttribute("numb_ped", numb_ped);
			return "redirect:Boleto";
		}
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("Boleto")
	public String Boleto(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "Boleto";
	}
	
	@RequestMapping(value = "Imprimir_Boleto")
	public String Imprimir_Boleto(Model model, Pedido pedido, HttpServletRequest request, HttpServletResponse response) {
		String numb_ped = request.getParameter("numb_ped");
		model.addAttribute("pedidos", dao_ped.Find_pedido_boleto(numb_ped));
		return "Imprimir_Boleto";
	}
	
}
