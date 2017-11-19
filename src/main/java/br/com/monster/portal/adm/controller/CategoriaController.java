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

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;
import br.com.monster.portal.modelDao.RelatorioDao;
import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;
import br.com.monster.portal.security.Permissoes;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class CategoriaController {

	@Autowired
	CategoriaDao dao;
		
	/*
	 * Registros e permissões
	 */
	// Define Entidade
	private EnumEntidade entidade = EnumEntidade.CATEGORIA;
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
		 *	2º Valida
		 *	3º Realiza ação no banco (criar)
		 *
		 *	@author Filipe A. Pimenta
		 *	@param Categoria - O Objeto principal para a criação
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */
	
	@RequestMapping("Admin/CreateCategoria")
	public String create(HttpSession session, @Valid Categoria categoria, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.CRIAR, entidade)){				//	Checar Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:categoria";										//	Volte para a página de adição
			} else {
				dao.create(categoria);											//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.CRIAR, entidade);	//	Relatório
				return "redirect:categoria";									//	Retorna para o método Read
			}
		}
		return "403";
	}

		/*
		 * -------------------------
		 * 			Read			
		 * -------------------------
		 *	1º Realiza ação no banco (ler)
		 *	2º Retorna para a página JSP
		 *
		 *	@author Filipe A. Pimenta
		 *	@return String - Página read (leitura)
		 */
		
	@RequestMapping("Admin/categoria")
	public String read(HttpSession session, Model model) {
		if(Permissoes.checar(session, EnumMetodo.LER, entidade)){				//	Consulta Permissão
			model.addAttribute("categorias", dao.read());						//	Consulta o Banco e coloca na variável da página
			return "admin/Categoria/read";										//	Retorna para á página JSP
		}
		return "403";
	}
		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 *	1º Valida
		 *	2º Realiza ação no banco (atualizar)
		 *	3º Retorna para o método READ
		 *
		 *	@author Filipe A. Pimenta
		 *	@param Categoria - O Objeto principal para a atualização
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */

	@RequestMapping("Admin/UpdateCategoria")
	public String update(HttpSession session, @Valid Categoria categoria, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:categoria";										//	Volte
			} else {
				dao.update(categoria);											//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.ATUALIZAR, entidade);	//	Gera Relatório e armazena no banco
				return "redirect:categoria";									//	Retorna para o método Read
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
		 *	1º Realiza ação no banco (excluir)
		 *
		 *	@author Filipe A. Pimenta
		 *	@param id Long - id do objeto a ser deletado
		 *	@return void - deletar não precisa de um retorno
		 */
		
	@RequestMapping("Admin/DeleteCategoria")
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
		 *	1º Realiza ação no banco (restaurar)
		 *
		 *	@author Filipe A. Pimenta
		 *	@param id Long - id do objeto a ser restaurado (após ser deletado)
		 *	@return void - restaurar não precisa de um retorno
		 */
		
	@RequestMapping("Admin/RestoreCategoria")
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
		 *	1º Realiza consulta no Banco
		 *
		 *	@author Filipe A. Pimenta
		 *	@param id Long - id do objeto a ser deletado
		 *	@return String - retorna uma página JSP
		 */
		
	@RequestMapping("Admin/FindCategoria")
	public String Find(Long id, HttpSession session, Model model) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta a permissão
			model.addAttribute("categoria", dao.findOne(id));					//	Consulta o Banco e coloca na variável da página
			return "admin/Categoria/edt";										//	Consulta o Banco e coloca na variável da página
		}	
		return"403";
	}
	
}

