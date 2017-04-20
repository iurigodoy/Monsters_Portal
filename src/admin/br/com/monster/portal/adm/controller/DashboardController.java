package br.com.monster.portal.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.DashboardDao;

@Transactional
@Controller
public class DashboardController {

	@Autowired
	DashboardDao dao;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Acessos")
	public String Acessos(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.Pedidos_por_semana());
		model.addAttribute("clientes", dao.Qtd_clientes());
		model.addAttribute("clientes_h", dao.Qtd_Clientes_Homens());
		model.addAttribute("clientes_m", dao.Qtd_Clientes_Mulheres());
		return "admin/Dashboard/acessos";
	}
	
	@RequestMapping("Admin/Pedidos")
	public String Compra(Model model, Pedido pedido) {
		//model.addAttribute("pedidos", dao.Read());
		return "admin/Dashboard/pedidos";
	}
	
}
