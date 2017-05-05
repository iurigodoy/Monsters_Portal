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
	 |				M�todos			|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateFuncionario")
	public String create(@Valid Funcionario funcionario, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:funcionario";
		} else {
			dao.create(funcionario);
			return "redirect:funcionario";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/funcionario")
	public String Read(Model model, Funcionario funcionario) {
		model.addAttribute("funcionarios", dao.read());
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
		    return "forward:funcionario";
		} else {
			dao.update(funcionario);
			return "redirect:funcionario";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteFuncionario")
	public void delete(Long id) {
	  dao.delete(id);
	}
	
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreFuncionario")
	public void restore(Long id) {
		  dao.restore(id);
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/FindFuncionario")
	public String Find(Model model, Long id) {
		model.addAttribute("funcionarios", dao.findOne(id));
		return "admin/Funcionario/edt";
	}

}
