package br.com.monster.portal.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.DashboardDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class DashboardController {

	@Autowired
	DashboardDao dao;
	
	/*

	 |==================================|
	 |				Métodos			|
	 |==================================|

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 *	1º Realiza ação no banco (ler)
	 *	2º Retorna para a página JSP
	 *
	 *	@author Filipe A. Pimenta
	 *	@return String - Página read (leitura)
	 */
	
	@RequestMapping("Admin/Acessos")
	public String Acessos(Model model, Pedido pedido) {					
		model.addAttribute("pedidos", dao.Pedidos_por_semana());		//	Consulta o Banco e coloca na variável da página
		model.addAttribute("clientes", dao.Qtd_clientes());				//	Consulta o Banco e coloca na variável da página
		model.addAttribute("clientes_h", dao.Qtd_Clientes_Homens());	//	Consulta o Banco e coloca na variável da página
		model.addAttribute("clientes_m", dao.Qtd_Clientes_Mulheres());	//	Consulta o Banco e coloca na variável da página
		return "admin/Dashboard/acessos";								//	Retorna para á página JSP
	}
	
	@RequestMapping("Admin/Pedidos")
	public String Compra(Model model, Pedido pedido) {
		//model.addAttribute("pedidos", dao.Read());					//	Consulta o Banco e coloca na variável da página
		return "admin/Dashboard/pedidos";								//	Retorna para á página JSP
	}
	
}
