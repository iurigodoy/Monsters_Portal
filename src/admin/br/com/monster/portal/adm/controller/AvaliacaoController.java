package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.AvaliacaoDao;

@Transactional
@Controller
public class AvaliacaoController {
	

		@Autowired
		AvaliacaoDao dao;
		
		/*

		 |==================================|
		 |				M�todos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/CreateAvaliacao")
		public String create(@Valid Avaliacao avaliacao, BindingResult result) {
			
			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.create(avaliacao);
				return "redirect:Produto";
			}
			
		}
		
		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Avaliacao")
		public String Read(Model model, Produto produto) {
			model.addAttribute("avaliacaos", dao.read(produto));
			return "admin/Avaliacao";
		}
		
		
		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/UpdateAvaliacao")
		public String update(@Valid Avaliacao avaliacao, BindingResult result) {

			if(result.hasErrors()) {
			    return "forward:Produto";
			} else {
				dao.update(avaliacao);
				return "redirect:Produto";
			}
		}
		
		/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreAvaliacao")
	public String restore(Long id) {
			dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Find_Avaliacao")
	public String find_one(Long id, Model model) {
	  model.addAttribute("avaliacaos", dao.findOne(id));
	  return "admin//Avaliacao";
	}
		
		
		
}