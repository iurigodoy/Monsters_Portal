package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Campanha;
import br.com.monster.portal.modelDao.CampanhaDao;

@Transactional
@Controller
public class CampanhaController {

	@Autowired
	CampanhaDao dao;

	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateCampanha")
	public String create(@Valid Campanha campanha, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Campanha";
		} else {
			dao.create(campanha);
			return "redirect:Add_Campanha";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Campanha")
	public String Read(Model model, Campanha campanha) {
		model.addAttribute("campanhas", dao.Read());
		return "admin/Campanha";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateCampanha")
	public String update(@Valid Campanha campanha, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Campanha";
		} else {
			dao.update(campanha);
			return "redirect:Campanha";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteCampanha")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Campanha";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreCampanha")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarCampanha")
	public String Find(Model model, Long id) {
		model.addAttribute("campanhas", dao.Find_One(id));
		return "admin/Campanha";
	}
	
}
