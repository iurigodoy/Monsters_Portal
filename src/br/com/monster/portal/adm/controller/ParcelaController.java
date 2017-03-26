package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Parcela;
import br.com.monster.portal.modelDao.ParcelaDao;

@Transactional
@Controller
public class ParcelaController {

	@Autowired
	ParcelaDao dao;

	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateParcela")
	public String create(@Valid Parcela parcela, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Parcela";
		} else {
			dao.create(parcela);
			return "redirect:Add_Parcela";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Parcela")
	public String Read(Model model, Parcela parcela) {
		model.addAttribute("parcelas", dao.Read());
		return "admin/Parcela";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateParcela")
	public String update(@Valid Parcela parcela, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Parcela";
		} else {
			dao.update(parcela);
			return "redirect:Parcela";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteParcela")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Parcela";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreParcela")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarParcela")
	public String Find(Model model, Long id) {
		model.addAttribute("parcelas", dao.Find_One(id));
		return "admin/Parcela";
	}
	
}
