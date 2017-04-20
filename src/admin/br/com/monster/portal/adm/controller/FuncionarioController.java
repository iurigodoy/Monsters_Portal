package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.CargoDao;
import br.com.monster.portal.modelDao.FuncionarioDao;

@Transactional
@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioDao dao;
	
	@Autowired
	CargoDao cargo_dao;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Add_Funcionario")
	public String create_page(Model model, Funcionario funcionario) {
		model.addAttribute("funcionarios", dao.Read());
		model.addAttribute("cargos", cargo_dao.Read());
		return "admin/Funcionario/adicionar";
	}
	
	@RequestMapping("Admin/CreateFuncionario")
	public String create(@Valid Funcionario funcionario, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Funcionario";
		} else {
			dao.create(funcionario);
			return "redirect:Funcionario";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Funcionario")
	public String Read(Model model, Funcionario funcionario) {
		model.addAttribute("funcionarios", dao.Read());
		return "admin/Funcionario/read";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateFuncionario")
	public String update(@Valid Funcionario funcionario, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Funcionario";
		} else {
			dao.update(funcionario);
			return "redirect:Funcionario";
		}
	}
	/*public String update(@Valid Funcionario funcionario, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Funcionario";
		} else {
			dao.update(funcionario);
			return "redirect:Funcionario";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteFuncionario")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Funcionario";
	}
	
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreFuncionario")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarFuncionario")
	public String Find(Model model, Long id) {
		model.addAttribute("funcionarios", dao.findOne(id));
		return "admin/Funcionario";
	}

}
