package br.com.monster.portal.adm.autenticacao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.FuncionarioDao;

@Transactional
@Controller
public class AuthAdmin {

	@Autowired
	FuncionarioDao dao;
	

	@RequestMapping("Admin/LoginAdmin")
	public String LoginAdmin(Model model) {
		return "admin/LoginAdmin";
	}
	
	@RequestMapping("Admin/LogoutAdmin")
	public String logoutAdmin(HttpSession session) {
	  session.invalidate();
	  return "redirect:LoginAdmin";
	}
	
	@RequestMapping("Admin/efetuaLoginAdmin")
	public String efetuaLoginAdmin(Model model,Funcionario funcionario, HttpSession session) {
		
<<<<<<< HEAD
	  Funcionario autentica = (Funcionario) dao.autenticaEmailSenha(funcionario.getEmail_fun(), funcionario.getSenha_fun());
	  if(autentica != null) {
		session.setAttribute("permissao", dao.getPermissao(autentica.getCargo().getId_cargo()));
	    session.setAttribute("administradorLogado", autentica);
	    return "redirect:produto";
=======
	  if(dao.FuncionarioExiste(funcionario) == true) {
	    session.setAttribute("administradorLogado", funcionario);
	    return "redirect:Produto";
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
	  }

	  model.addAttribute("login_error", "Usuário ou senha incorretos");
	  return "redirect:LoginAdmin";
	}
}
