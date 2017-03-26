package br.com.monster.portal.adm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.model.Produto;
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
	
	@RequestMapping("Admin/Add_Pedido")
	public String create_page(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.Read());
		model.addAttribute("produtos", dao_prod.Read());
		model.addAttribute("clientes", dao_cli.Read());
		return "admin/Pedido/adicionar";
	}
	
	@RequestMapping("Admin/CreatePedido")
	public String create(@Valid Pedido pedido, @Valid Produto produto, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Pedido";
		} else {
			dao.create(pedido);
			return "redirect:Pedido";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Pedido")
	public String Read(Model model, Pedido pedido) {
		model.addAttribute("pedidos", dao.Read());
		return "admin/Pedido/visualizar";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdatePedido")
	public String update(@Valid Pedido pedido, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Pedido";
		} else {
			dao.update(pedido);
			return "redirect:Pedido";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeletePedido")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Pedido";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestorePedido")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarPedido")
	public String Find(Model model, Pedido pedido,
			 HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
			
			//pega os parametros
			String data_request = request.getParameter("data_pedido");

			if(data_request != null && !data_request.isEmpty() && data_request != "__/__/__" && data_request != ""){
				
				//Formata para data
				String data_request2 = data_request.replace('/', '-');
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date data_pedido = (Date) sdf.parse(data_request2);
		
				model.addAttribute("pedidos", dao.Find_By_Date(data_pedido));
				
			} else {
			    return "forward:Pedido";
			}
			
			model.addAttribute("pedi_page", "active");
			return "admin/Pedido";

	}
	
}
