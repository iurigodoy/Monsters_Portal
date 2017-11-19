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

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.modelDao.BannerDao;
import br.com.monster.portal.modelDao.ProdutoDao;
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
public class BannerController {

	@Autowired
	BannerDao dao;

	@Autowired
	ProdutoDao dao_prod;
	
	/*
	 * Registros e permissões
	 */
	// Define Entidade
	private EnumEntidade entidade = EnumEntidade.BANNER;
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
	 *	1º Valida
	 *	2º Realiza ação no banco (criar)
	 *	
	 *	@author Filipe A. Pimenta
	 *	@param Banner - O Objeto principal para a criação
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */
	
	@RequestMapping("Admin/CreateBanner")
	public String create(HttpSession session, @Valid Banner banner, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.CRIAR, entidade)){				//	Checar Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:banner";										//	Volte para a página de adição
			} else {
				dao.create(banner);												//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.CRIAR, entidade);	//	Relatório
				return "redirect:banner";										//	Retorna para o método Read
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
	
	@RequestMapping("Admin/banner")
	public String Read(HttpSession session, Model model, Banner banner) {
		if(Permissoes.checar(session, EnumMetodo.LER, entidade)){
			model.addAttribute("banners", dao.read());							//	Consulta o Banco e coloca na variável da página
			model.addAttribute("produtos", dao_prod.read());
			return "admin/Banner/read";											//	Consulta o Banco e coloca na variável da página
		}																		//	Retorna para á página JSP
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
	 *	@param Banner - O Objeto principal para a atualização
	 *	@return String - Manipulado pelo Spring para o método read (leitura)
	 */

	@RequestMapping("Admin/UpdateBanner")
	public String update(HttpSession session, @Valid Banner banner, BindingResult result) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta Permissão
			if(result.hasErrors()) {											//	Se houver erro na validação
			    return "forward:banner";										//	Volte
			} else {
				dao.update(banner);												//	Ação no banco
				relatorio.gerarRelatorio(session, EnumMetodo.ATUALIZAR, entidade);	//	Gera Relatório e armazena no banco
				return "redirect:banner";										//	Retorna para o método Read
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
	
	@RequestMapping("Admin/DeleteBanner")
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
	
	@RequestMapping("Admin/RestoreBanner")
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
	
	
	@RequestMapping("Admin/FindBanner")
	public String Find(Long id, HttpSession session, Model model) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta a permissão
			model.addAttribute("banner", dao.findOne(id));						//	Consulta o Banco e coloca na variável da página
			return "admin/Banner/edt";											//	Consulta o Banco e coloca na variável da página
		}
		return"403";
	}
	
}

