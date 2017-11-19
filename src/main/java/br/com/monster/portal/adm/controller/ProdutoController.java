package br.com.monster.portal.adm.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.FornecedorMultiple;
import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.FornecedorDao;
import br.com.monster.portal.modelDao.ProdutoDao;
import br.com.monster.portal.modelDao.RelatorioDao;
import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;
import br.com.monster.portal.security.Permissoes;

/*
 * @author Iuri Godoy
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class ProdutoController {

	@Autowired
	ProdutoDao dao;
	
	@Autowired
	CategoriaDao cat_dao;

	@Autowired
	FornecedorDao forc_dao;
	
	/*
	 * Registros e permissões
	 */
	// Define Entidade
	private EnumEntidade entidade = EnumEntidade.PRODUTO;
	// Consulta a interface RelatorioDao
	@Autowired
	RelatorioDao relatorio;
	
	/*

	 |==================================|
	 |				Métodos				|
	 |==================================|
	 * -------------------------
	 * 			Create			
	 * -------------------------
	 *	1º Consulta Permissão
	 *	2º Valida
	 *	3º Realiza ação no banco (criar)
	 *	4º Gera Relatório
	 *
	 *	@author Iuri Godoy
	 *	@param Produto - O Objeto principal para a criação
	 *	@param ImagemMultiple - Podem ser inseridas multiplas imagens para um produto
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */
	
	@RequestMapping("Admin/adicionar_produto")
	public String create_page(Model model) {
		model.addAttribute("produtos", dao.read());
		model.addAttribute("fornecedores", forc_dao.read());
		model.addAttribute("categorias", cat_dao.read());
		return "admin/Produto/adicionar";
	}
	
	@RequestMapping("Admin/CreateProduto")
	public String create(HttpSession session, @Valid Produto produto, ImagemMultiple imagens, FornecedorMultiple fornecedores, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.CRIAR, entidade)){				//	Checar Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:adicionar_produto";								//	Volte para a página de adição
			} else {
				dao.create(produto, imagens, fornecedores);						//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.CRIAR, entidade);	//	Relatório
				return "redirect:produto";										//	Retorna para o método Read
			}
		}
		return "403";
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 *	1º Consulta Permissão
	 *	2º Realiza ação no banco (ler)
	 *	3º Retorna para a página JSP
	 *
	 *	@author Iuri Godoy
	 *	@return String - Página read (leitura)
	 */
	
	@RequestMapping("Admin/produto")
	public String read(HttpSession session, Model model) {
		
		if(Permissoes.checar(session, EnumMetodo.LER, entidade) == true){				//	Consulta Permissão
			model.addAttribute("produtos", dao.read());							//	Consulta o Banco e coloca na variável da página
			return "admin/Produto/read";										//	Retorna para á página JSP
		}
		return "403";
		
	}
	
	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 *	1º Consulta Permissão
	 *	2º Valida
	 *	3º Realiza ação no banco (atualizar)
	 *	4º Gera Relatório
	 *	5º Retorna para o método READ
	 *
	 *	@author Iuri Godoy
	 *	@param Produto - O Objeto principal para a atualização
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */

	@RequestMapping("Admin/UpdateProduto")
	public String update(HttpSession session, @Valid Produto produto, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:produto";										//	Volte
			} else {
				dao.update(produto);											//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.ATUALIZAR, entidade);	//	Gera Relatório e armazena no banco
				return "redirect:produto";										//	Retorna para o método Read
			}
		}
		return "403";
		
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 *	Requisição AJAX
	 *
	 *	1º Consulta Permissão
	 *	2º Realiza ação no banco (excluir)
	 *	3º Gera Relatório
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser deletado
	 *	@return void - deletar não precisa de um retorno
	 */
	
	@RequestMapping("Admin/DeleteProduto")
	public void delete(HttpSession session, Long id, HttpServletResponse response) {
		if(Permissoes.checar(session, EnumMetodo.EXCLUIR, entidade)){			//	Consulta a permissão
			dao.delete(id);														//	Ação no banco
			relatorio.gerarRelatorio(session, EnumMetodo.EXCLUIR, entidade);	//	Gera Relatório e armazena no banco
			response.setStatus(200);											//	Indica para a requisição AJAX que tudo ocorreu bem
		}
	} 
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 *	Requisição AJAX
	 *
	 *	1º Consulta Permissão
	 *	2º Realiza ação no banco (restaurar)
	 *	3º Gera Relatório
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser restaurado (após ser deletado)
	 *	@return void - restaurar não precisa de um retorno
	 */
	
	@RequestMapping("Admin/RestoreProduto")
	public void restore(HttpSession session, Long id, HttpServletResponse response) {
		if(Permissoes.checar(session, EnumMetodo.RESTAURAR, entidade)){			//	Consulta a permissão
			dao.restore(id);													//	Ação no banco
			relatorio.gerarRelatorio(session, EnumMetodo.RESTAURAR, entidade);	//	Gera Relatório e armazena no banco
			response.setStatus(200);											//	Indica para a requisição AJAX que tudo ocorreu bem
		}
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 *	Requisição AJAX
	 * 
	 *	1º Consulta Permissão
	 *	2º Realiza consulta no Banco
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser deletado
	 *	@return String - retorna uma página JSP
	 */
	
	@RequestMapping("Admin/FindProduto")
	public String Find(Long id, HttpSession session, Model model) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta a permissão
			model.addAttribute("produto", dao.findOne(id));						//	Consulta o Banco e coloca na variável da página
			model.addAttribute("fornecedores", forc_dao.read());				//	Consulta o Banco e coloca na variável da página
			model.addAttribute("categorias", cat_dao.read());					//	Consulta o Banco e coloca na variável da página
			return "admin/Produto/edt";											//	Retorna para a página JSP edt
		}
		return"403";
	}
	
}
