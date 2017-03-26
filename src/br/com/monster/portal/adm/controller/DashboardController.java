package br.com.monster.portal.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.modelDao.PedidoDao;

@Transactional
@Controller
public class DashboardController {

	@Autowired
	PedidoDao dao;

	@Autowired
	ClienteDao dao_cli;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Acessos")
	public String Acessos(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.Pedidos_por_semana());
		model.addAttribute("clientes", dao_cli.Qtd_clientes());
		model.addAttribute("clientes_h", dao_cli.Qtd_Clientes_Homens());
		model.addAttribute("clientes_m", dao_cli.Qtd_Clientes_Mulheres());
		return "admin/Dashboard/acessos";
	}
	
	@RequestMapping("Admin/Pedidos")
	public String Compra(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.Read());
		return "admin/Dashboard/pedidos";
	}
	
}
