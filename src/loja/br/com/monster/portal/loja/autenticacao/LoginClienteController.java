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
		model.addAttribute("categorias", dao_cat.Read());
		return "Login";
	}

	@RequestMapping("LoginEsqueciSenha")
	public String LoginEsqueciSenha(Model model) {
		model.addAttribute("login_page", "active");
		model.addAttribute("categorias", dao_cat.Read());
		return "LoginEsqueciSenha";
	}
	
	@RequestMapping("Logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:index";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Cliente cliente, HttpSession session, Model model) {

	  cliente.setSenha_cli(cliente.getSenha_cli());
	  if(dao.UsuarioExiste(cliente) == true) {
	    session.setAttribute("clienteLogado", cliente);
		session.setAttribute("clienteLogadoInfo", dao.SeUsuarioExiste(cliente));
	    return "redirect:index";
	  }
	  
	  model.addAttribute("login_error", "Usuário ou senha incorretos");
	  return "redirect:Login";
	}
}
