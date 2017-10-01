package br.com.monster.portal.identificacao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;

@Transactional
@Controller
public class IdentificacaoCompraController extends Identificacao {
	
	/*
	 * Login
	 */
	@RequestMapping("loginIdentificacao")
	public String login(String email, String senha, HttpSession session, Model model) {
		return loginDao(email, senha, session, model, "forma_de_pagamento", "identificacao");
	}
	
	/*
	 * Cadastro
	 */
	// Cria o Cliente e redireciona para a forma de pagamento
	@RequestMapping("CreateIdentificacaoCliente")
	public String cadastro(@Valid Cliente cliente, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {															// Valida
		    return "forward:identificacao";													// Retorna erro
		} else {
			return cadastroDao(cliente, session, model, "forma_de_pagamento", "identificacao");	// Efetua Login do tipo identificacao
		}
	}
	
	@RequestMapping(value = "/comprar_agora")
	public String comprarAgora(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "identificacao/cadastroComprarAgora";
	}
	
	@RequestMapping(value = "/CadastroComprarAgora")
	public String cadastroComprarAgora(Model model, HttpSession session, Cliente cliente) {
		model.addAttribute("categorias", dao_cat.read());
		session.setAttribute("clienteLogado", cliente);
		return "redirect:forma_de_pagamento";
	}
}
