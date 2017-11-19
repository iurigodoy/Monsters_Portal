package br.com.monsterportal.identificacao;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.ClienteDao;

public abstract class Identificacao {

	@Autowired
	protected CategoriaDao dao_cat;
	
	@Autowired
	private ClienteDao dao_cli;

	//abstract String login_page(Model model);
	abstract String login(String email, String senha, HttpSession session, Model model);
	//abstract String cadastro_page(Model model);
	abstract String cadastro(Cliente cliente,BindingResult result, Model model, HttpSession session);
	
	protected String loginDao(String email, String senha, HttpSession session,
			Model model, String paginaSucesso, String paginaErro){
		
		Cliente autenticacao = (Cliente) dao_cli.autenticaEmailSenha(email, senha);	// Faz autentica��o do cliente pelo email e senha e retorna com todos os dados
		if(autenticacao != null) {													// Checa se n�o veio nula
			session.setAttribute("clienteLogado", autenticacao);					// Armazena os dados na sessão
			return "redirect:"+paginaSucesso;										// Redireciona para a página
		}
		model.addAttribute("login_error", "Usuário ou senha incorretos");			// Mensagem de erro
		return "redirect:"+paginaErro;												// redireciona de volta para a página
	}
	
	protected String cadastroDao(Cliente cliente, HttpSession session, Model model,
			String paginaSucesso, String paginaErro) {
		String email = cliente.getEmail_cli();										// pega email
		String senha = cliente.getSenha_cli();										// pega senha antes de ser criptografado pelo metodo create
		dao_cli.create(cliente);													// Cria Cliente
		return loginDao(email, senha, session, model, paginaSucesso, paginaErro);	// Efetua Login do tipo identificacao
	}
}