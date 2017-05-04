package br.com.monster.portal.loja.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ClienteDao;
import br.com.monster.portal.modelDao.PedidoDao;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	CategoriaDao dao_cat;
	
	@Autowired
	PedidoDao dao_ped;
	
	@Autowired
	ClienteDao dao_cli;

	/*
	 *==============================
	 * 			Usu�rio				
	 *==============================
	 */
	
	@RequestMapping("Cadastro")
	public String Cadastro(Model model) {
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		return "Cadastro";
	}
	
	@RequestMapping("CreateCliente")
	public String create(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
		    return "forward:Cadastro";
		} else {
			dao_cli.create(cliente);
			return "redirect:index";
		}
		
	}
	
	@RequestMapping("MinhaConta")
	public String MinhaConta(Model model, HttpSession session, Pedido pedido) {
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho

		@SuppressWarnings("unchecked")
		ArrayList< Cliente > clienteInfo = (ArrayList<Cliente>) session.getAttribute("clienteLogadoInfo");
		Cliente Id_cli = clienteInfo.get(0);
		
		model.addAttribute("pedidos", dao_ped.Find_ped_cli(Id_cli));
		return "MinhaConta";
	}
	
	@RequestMapping("Carrinho")
	public String Carrinho(Model model) {
		model.addAttribute("categorias", dao_cat.Read());	// Cabeçalho
		return "Carrinho";
	}
}
