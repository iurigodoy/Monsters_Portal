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
<<<<<<< HEAD
		model.addAttribute("categorias", dao_cat.read());
=======
		model.addAttribute("login_page", "active");
		model.addAttribute("categorias", dao_cat.Read());
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
		return "Login";
	}

	@RequestMapping("LoginEsqueciSenha")
	public String LoginEsqueciSenha(Model model) {
<<<<<<< HEAD
		model.addAttribute("categorias", dao_cat.read());
=======
		model.addAttribute("login_page", "active");
		model.addAttribute("categorias", dao_cat.Read());
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
		return "LoginEsqueciSenha";
	}
	
	@RequestMapping("Logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:index";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Cliente cliente, HttpSession session, Model model) {
<<<<<<< HEAD
		
		String email = cliente.getEmail_cli();
		String senha = cliente.getSenha_cli();
		
	  
	  if(dao.autenticaEmailSenha(email, senha) != null) {							// Checa se n„o veio nula
		Cliente autenticacao = (Cliente) dao.autenticaEmailSenha(email, senha);		// Faz autenticaÁ„o do cliente pelo email e senha e retorna com todos os dados
	    session.setAttribute("clienteLogado", autenticacao);						// Armazena os dados na sess„o
	    return "redirect:index";													// Redireciona para a p·gina
=======

	  cliente.setSenha_cli(cliente.getSenha_cli());
	  if(dao.UsuarioExiste(cliente) == true) {
	    session.setAttribute("clienteLogado", cliente);
		session.setAttribute("clienteLogadoInfo", dao.SeUsuarioExiste(cliente));
	    return "redirect:index";
>>>>>>> parent of f45fb1a... Vers√£o do Semestre Passado
	  }
	  
	  model.addAttribute("login_error", "Usu√°rio ou senha incorretos");
	  return "redirect:Login";
	}
}
