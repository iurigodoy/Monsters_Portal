package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.modelDao.FornecedorDao;

@Transactional
@Controller
public class FornecedorController {

	@Autowired
	FornecedorDao dao;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Add_Fornecedor")
	public String create_page(Model model) {
		model.addAttribute("fornecedores", dao.Read());
		return "admin/Fornecedor/adicionar";
	}
	
	@RequestMapping("Admin/CreateFornecedor")
	public String create(@Valid Fornecedor fornecedor, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Fornecedor";
		} else {
			dao.create(fornecedor);
			return "redirect:Fornecedor";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Fornecedor")
	public String Read(Model model) {
		model.addAttribute("fornecedores", dao.Read());
		return "admin/Fornecedor/visualizar";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateFornecedor")
	public String update(@Valid Fornecedor fornecedor, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Fornecedor";
		} else {
			dao.update(fornecedor);
			return "redirect:Fornecedor";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteFornecedor")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Fornecedor";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreFornecedor")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarFornecedor")
	public String Find(Model model, Long id) {
		model.addAttribute("fornecedores", dao.findOne(id));
		return "admin/Fornecedor";
	}

}
