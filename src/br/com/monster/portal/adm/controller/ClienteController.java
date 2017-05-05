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
	
	@RequestMapping("Admin/adicionar_cliente")
	public String create_page(Model model) {
		model.addAttribute("clie_page", "active");
		model.addAttribute("clientes", dao.read());
		return "admin/Cliente/adicionar";
	}
	
	@RequestMapping("Admin/CreateCliente")
	public String createAdmin(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
		    return "forward:adicionar_cliente";
		} else {
			dao.create(cliente);
			return "redirect:cliente";
		}
		
	}
	
	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/cliente")
	public String Read(Model model) {
		model.addAttribute("clientes", dao.read());
		return "admin/Cliente/read";
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
	public void bloquear(Cliente cliente) {
	  //dao.delete(cliente);
	}
	
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreCliente")
	public void restore(Long id) {
		dao.restore(id);
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/FindCliente")
	public String find_one(Long id, Model model) {
	  model.addAttribute("clientes", dao.findOne(id));
	  return "admin/Cliente/edt";
	}
	
}
