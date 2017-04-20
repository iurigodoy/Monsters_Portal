package br.com.monster.portal.adm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.BannerDao;
import br.com.monster.portal.modelDao.ProdutoDao;

@Transactional
@Controller
public class BannerController {

	@Autowired
	BannerDao dao;

	@Autowired
	ProdutoDao dao_prod;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|

	 * -------------------------
	 * 			Create			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/CreateBanner")
	public String create(@Valid Banner banner, BindingResult result) {
		
		if(result.hasErrors()) {
		    return "forward:Add_Banner";
		} else {
			dao.create(banner);
			return "redirect:Add_Banner";
		}
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/Banner")
	public String Read(Model model, Produto produto) {
		model.addAttribute("banners", dao.Read());
		model.addAttribute("produtos", dao_prod.Read());
		return "admin/Banner/visualizar";
	}

	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 */

	@RequestMapping("Admin/UpdateBanner")
	public String update(@Valid Banner banner, BindingResult result) {

		if(result.hasErrors()) {
		    return "forward:Banner";
		} else {
			dao.update(banner);
			return "redirect:Banner";
		}
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/DeleteBanner")
	public String delete(Long id) {
	  dao.delete(id);
	  return "redirect:Banner";
	}
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/RestoreBanner")
	public String restore(Long id) {
		  dao.restore(id);
		  return "delete";
	}

	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 */
	
	@RequestMapping("Admin/ProcurarBanner")
	public String Find(Model model, Long id) {
		model.addAttribute("banners", dao.findOne(id));
		return "admin/Banner/visualizar";
	}
	
}
