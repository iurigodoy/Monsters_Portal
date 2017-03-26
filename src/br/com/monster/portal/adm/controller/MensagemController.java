package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Mensagem;
import br.com.monster.portal.modelDao.MensagemDao;

@Transactional
@Controller
public class MensagemController {

	@Autowired
	MensagemDao dao;

	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateMensagem")
	public String create(@Valid Mensagem mensagem, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Mensagem";
		} else {
			dao.create(mensagem);
			return "redirect:Add_Mensagem";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Mensagem")
	public String Read(Model model, Mensagem mensagem) {
		model.addAttribute("mensagens", dao.Read());
		return "admin/Mensagem";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateMensagem")
	public String update(@Valid Mensagem mensagem, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Mensagem";
		} else {
			dao.update(mensagem);
			return "redirect:Mensagem";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteMensagem")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Mensagem";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreMensagem")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarMensagem")
	public String Find(Model model, Long id) {
		model.addAttribute("mensagens", dao.Find_One(id));
		return "admin/Mensagem";
	}
	
}
