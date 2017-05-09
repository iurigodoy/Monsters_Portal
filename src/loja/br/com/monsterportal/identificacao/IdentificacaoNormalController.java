package br.com.monsterportal.identificacao;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;

@Controller
public class IdentificacaoNormalController extends Identificacao {

	private String paginaSucesso = "index";
	private String paginaErro = "Login";
	
	/*
	 * Login
	 */
	// Login page
	@RequestMapping("Login")
	public String login_page(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "Login";
	}
	
	// Login
	@RequestMapping("efetuaLogin")
	public String login(String email, String senha, HttpSession session, Model model) {
		return loginDao(email, senha, session, model, paginaSucesso, paginaErro);
	}
	
	/*
	 * Cadastro
	 */
	// Cadastro page
	@RequestMapping("Cadastro")
	public String cadastro_page(Model model) {
		model.addAttribute("categorias", dao_cat.read());	// Cabeçalho
		return "Cadastro";
	}
	
	// Cria o Cliente e efetua o login
	@RequestMapping("CreateCliente")
	public String cadastro(@Valid Cliente cliente, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {															// Valida
		    return "forward:Cadastro";														// Retorna erro
		} else {
			return cadastroDao(cliente, session, model, paginaSucesso, paginaErro);			// Efetua Login do tipo identificacao
		}
	}

}
