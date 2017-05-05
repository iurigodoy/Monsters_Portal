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
	
	@RequestMapping("Admin/CreateFornecedor")
	public String create(@Valid Fornecedor fornecedor, BindingResult result) {
		if(result.hasErrors()) {
		    return "forward:fornecedor";
		} else {
			dao.create(fornecedor);
			return "redirect:fornecedor";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/fornecedor")
	public String Read(Model model) {
		model.addAttribute("fornecedores", dao.read());
		return "admin/Fornecedor/read";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateFornecedor")
	public String update(@Valid Fornecedor fornecedor, BindingResult result) {
		if(result.hasErrors()) {
		    return "forward:fornecedor";
		} else {
			dao.update(fornecedor);
			return "redirect:fornecedor";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteFornecedor")
	public void delete(Long id) {
	  dao.delete(id);
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreFornecedor")
	public void restore(Long id) {
		  dao.restore(id);
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/FindFornecedor")
	public String Find(Model model, Long id) {
		model.addAttribute("fornecedores", dao.findOne(id));
		return "admin/Fornecedor/edt";
	}

}
