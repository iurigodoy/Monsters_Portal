package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;

@Transactional
@Controller
public class ClienteController {

	@Autowired
	ClienteDao dao;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|


	/*
	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Add_Cliente")
	public String create_page(Model model) {
		model.addAttribute("clie_page", "active");
		model.addAttribute("clientes", dao.Read());
		return "admin/Cliente/adicionar";
	}
	
	@RequestMapping("Admin/CreateCliente")
	public String createAdmin(@Valid Cliente cliente, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Cliente";
		} else {
			dao.create(cliente);
			return "redirect:Cliente";
		}
		
	}
	
	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Cliente")
	public String Read(Model model) {
		model.addAttribute("clie_page", "active");
		model.addAttribute("clientes", dao.Read());
		return "admin/Cliente/visualizar";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("UpdateCliente")
	public String update(@Valid Cliente cliente, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:MinhaConta";
		} else {
			dao.update(cliente);
			return "redirect:MinhaConta";
		}
	}

	@RequestMapping("/Admin/UpdateCliente")
	public String updateAdmin(@Valid Cliente cliente, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Cliente";
		} else {
			dao.update(cliente);
			return "redirect:Cliente";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteCliente")
	public String delete(Cliente cliente) {
	  //dao.delete(cliente);
	  return "redirect:Cliente";
	}
	
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("RestoreCliente")
	public String restore(Long id) {
		dao.restore(id);
		  return "delete";
	}
	
}
