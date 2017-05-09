package br.com.monsterportal.identificacao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;

@Controller
public class IdentificacaoCompraController extends Identificacao {

	String paginaSucesso = "forma_de_pagamento";
	String paginaErro = "identificacao";
	
	/*
	 * Login
	 */
	@RequestMapping("LoginIdentificacao")
	public String login(String email, String senha, HttpSession session, Model model) {
		return loginDao(email, senha, session, model, paginaSucesso, paginaErro);
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
			return cadastroDao(cliente, session, model, paginaSucesso, paginaErro);	// Efetua Login do tipo identificacao
		}
	}
}
