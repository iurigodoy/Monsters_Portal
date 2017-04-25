package br.com.monster.portal.loja.autenticacao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ClienteDao;

@Transactional
@Controller
public class LoginClienteController {

	@Autowired
	ClienteDao dao;
	
	@Autowired
	CategoriaDao dao_cat;

	
	@RequestMapping("Login")
	public String Login(Model model) {
		model.addAttribute("login_page", "active");
		model.addAttribute("categorias", dao_cat.read());
		return "Login";
	}

	@RequestMapping("LoginEsqueciSenha")
	public String LoginEsqueciSenha(Model model) {
		model.addAttribute("login_page", "active");
		model.addAttribute("categorias", dao_cat.read());
		return "LoginEsqueciSenha";
	}
	
	@RequestMapping("Logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:index";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(String email, String senha,
			Cliente cliente, HttpSession session, Model model) {
		
	  Cliente autenticacao = (Cliente) dao.autenticaEmailSenha(email, senha);		// Faz autenticação do cliente pelo email e senha e retorna com todos os dados
	  if(autenticacao != null) {													// Checa se não veio nula
	    session.setAttribute("clienteLogado", autenticacao);						// Armazena os dados na sessão
	    return "redirect:index";													// Redireciona para a página
	  }
	  
	  model.addAttribute("login_error", "Usuário ou senha incorretos");
	  return "redirect:Login";
	}
}
