package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.ListaProduto;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.modelDao.PedidoDao;
import br.com.monster.portal.modelDao.ProdutoDao;

@Transactional
@Controller
public class PedidoController {

	@Autowired
	PedidoDao dao;

	@Autowired
	ProdutoDao dao_prod;
	
	@Autowired
	ClienteDao dao_cli;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/adicionar_pedido")
	public String create_page(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.read());
		model.addAttribute("produtos", dao_prod.read());
		model.addAttribute("clientes", dao_cli.read());
		return "admin/Pedido/adicionar";
	}
	
	@RequestMapping("Admin/CreatePedido")
	public String create(@Valid Pedido pedido, ListaProduto produtos, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:adicionar_pedido";
		} else {
			dao.create(pedido, produtos);
			return "redirect:adicionar_pedido";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/pedido")
	public String Read(Model model) {
		model.addAttribute("pedidos", dao.read());
		return "admin/Pedido/read";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdatePedido")
	public String update(@Valid Pedido pedido, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:pedido";
		} else {
			dao.update(pedido);
			return "redirect:pedido";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeletePedido")
	public void delete(Long id) {
	  dao.delete(id);
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestorePedido")
	public void restore(Long id) {
		  dao.restore(id);
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/FindPedido")
	public String find(Model model, Long id) {
			model.addAttribute("pedido", dao.findOne(id));
			model.addAttribute("produtos", dao_prod.read());
			model.addAttribute("clientes", dao_cli.read());
			return "admin/Pedido/edt";
	}
	
}
