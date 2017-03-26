package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Mailing;
import br.com.monster.portal.modelDao.MailingDao;

@Transactional
@Controller
public class MailingController {

	@Autowired
	MailingDao dao;

	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateMailing")
	public String create(@Valid Mailing mailing, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Mailing";
		} else {
			dao.create(mailing);
			return "redirect:Add_Mailing";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Mailing")
	public String Read(Model model, Mailing mailing) {
		model.addAttribute("mailings", dao.Read());
		return "admin/Mailing";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateMailing")
	public String update(@Valid Mailing mailing, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Mailing";
		} else {
			dao.update(mailing);
			return "redirect:Mailing";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteMailing")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Mailing";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreMailing")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarMailing")
	public String Find(Model model, Long id) {
		model.addAttribute("mailings", dao.Find_One(id));
		return "admin/Mailing";
	}
	
}
