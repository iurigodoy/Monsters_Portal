package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;
@Transactional
@Controller
public class CategoriaController {
	

		@Autowired
		CategoriaDao dao;
		
		/*

		 |==================================|
		 |				M�todos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/CreateCategoria")
		public String create(@Valid Categoria categoria, BindingResult result) {
			if(result.hasErrors()) {
			    return "forward:categoria";
			} else {
				dao.create(categoria);
				return "redirect:categoria";
			}
			
		}

		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/categoria")
		public String Read(Model model) {
			model.addAttribute("categorias", dao.read());
			return "admin/Produto/categoria";
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/UpdateCategoria")
		public String update(@Valid Categoria categoria, BindingResult result) {
			if(result.hasErrors()) {
			    return "forward:categoria";
			} else {
				dao.update(categoria);
				return "redirect:categoria";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/DeleteCategoria")
		public void delete(Long id) {
		  dao.delete(id);
		}
		
	
		/*
		 * -------------------------
		 * 			Restore			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/RestoreCategoria")
		public void restore(Long id) {
			  dao.restore(id);
		}

		/*
		 * -------------------------
		 * 			Find			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/FindCategoria")
		public String find_one(Long id, Model model) {
		  model.addAttribute("categorias", dao.findOne(id));
		  return "admin/Categoria/edt";
		}
		
}
