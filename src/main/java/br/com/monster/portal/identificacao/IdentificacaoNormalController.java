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
public class IdentificacaoNormalController extends Identificacao {
	
	/*
	 * Login
	 */
	// Login page
	@RequestMapping("login")
	public String login_page(Model model) {
		model.addAttribute("categorias", dao_cat.read());
		return "identificacao/login";
	}
	
	// Login
	@RequestMapping("efetuaLogin")
	public String login(String email, String senha, HttpSession session, Model model) {
		return loginDao(email, senha, session, model, "index", "login");
	}
	
	/*
	 * Cadastro
	 */
	// Cadastro page
	@RequestMapping("cadastro")
	public String cadastro_page(Model model) {
		model.addAttribute("categorias", dao_cat.read());					// Cabeçalho
		return "identificacao/cadastro";
	}
	
	// Cria o Cliente e efetua o login
	@RequestMapping("CreateCliente")
	public String cadastro(@Valid Cliente cliente, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {											// Valida
		    return "forward:cadastro";										// Retorna erro
		} else {
			return cadastroDao(cliente, session, model, "index", "login");	// Efetua Login do tipo identificacao
		}
	}
	
	// Logout
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:index";
	}

}
