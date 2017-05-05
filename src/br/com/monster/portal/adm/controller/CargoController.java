package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.modelDao.CargoDao;
@Transactional
@Controller
public class CargoController {

		@Autowired
		CargoDao dao;
		
		/*

		 |==================================|
		 |				M�todos				|
		 |==================================|

		 * -------------------------
		 * 			Create			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Createcargo")
		public String create(@Valid Cargo cargo, BindingResult result) {
			if(result.hasErrors()) {
			    return "forward:cargo";
			} else {
				dao.create(cargo);
				return "redirect:cargo";
			}
			
		}

		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/cargo")
		public String Read(Model model) {
			model.addAttribute("cargos", dao.read());
			return "admin/Cargo/read";
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 */

		@RequestMapping("Admin/Updatecargo")
		public String update(@Valid Cargo cargo, BindingResult result) {
			if(result.hasErrors()) {
			    return "forward:cargo";
			} else {
				dao.update(cargo);
				return "redirect:cargo";
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Deletecargo")
		public void delete(Long id) {
		  dao.delete(id);
		}
		
		/*
		 * -------------------------
		 * 			Restore			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Restorecargo")
		public void restore(Long id) {
			  dao.restore(id);
		}

		/*
		 * -------------------------
		 * 			Find			
		 * -------------------------
		 */
		
		@RequestMapping("Admin/Find_Cargo")
		public String find_one(Long id, Model model) {
		  model.addAttribute("cargos", dao.findOne(id));
		  return "admin/Cargo/edt";
		}
}
