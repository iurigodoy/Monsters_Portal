package br.com.monster.portal.adm.controller;

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
 * @since Release 03 do 5� semestre
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
	 * Registros e permiss�es
	 */
	// Define Entidade
	private EnumEntidade entidade = EnumEntidade.PRODUTO;
	// Consulta a interface RelatorioDao
	@Autowired
	RelatorioDao relatorio;
	
	/*

	 |==================================|
	 |				M�todos				|
	 |==================================|
	 */
	// P�gina de adi��o
	@RequestMapping("Admin/adicionar_produto")
	public String create_page(HttpSession session, Model model) {
		
		if(Permissoes.checar(session, EnumMetodo.CRIAR, entidade)){
			model.addAttribute("produtos", dao.read());
			model.addAttribute("fornecedores", forc_dao.read());
			model.addAttribute("categorias", cat_dao.read());
			return "admin/Produto/adicionar";
		}
		return "403";
		
	}

	/*
	 * -------------------------
	 * 			Create			
	 * -------------------------
	 *	1� Consulta Permiss�o
	 *	2� Valida
	 *	3� Realiza a��o no banco (criar)
	 *	4� Gera Relat�rio
	 *
	 *	@author Iuri Godoy
	 *	@param Produto - O Objeto principal para a cria��o
	 *	@param ImagemMultiple - Podem ser inseridas multiplas imagens para um produto
	 *	@return String - Manipulado pelo Spring para o m�todo read (leitura)
	 */
	
	@RequestMapping("Admin/Add_Produto")
	public String create_page(Model model) {
		model.addAttribute("produtos", dao.read());
		model.addAttribute("fornecedores", forc_dao.read());
		model.addAttribute("categorias", cat_dao.read());
		return "admin/Produto/adicionar";
	}
	
	@RequestMapping("Admin/CreateProduto")
	public String create(HttpSession session, @Valid Produto produto, ImagemMultiple imagens, FornecedorMultiple fornecedores, BindingResult result) {
		
		if(Permissoes.checar(session, EnumMetodo.CRIAR, entidade)){				//	Checar Permiss�o
			if(result.hasErrors()) {											//	Se houver erro na valida��o
			    return "forward:adicionar_produto";								//	Volte para a p�gina de adi��o
			} else {
				dao.create(produto, imagens, fornecedores);									//	A��o no banco
				relatorio.gerarRelatorio(session, EnumMetodo.CRIAR, entidade);	//	Relat�rio
				return "redirect:produto";										//	Retorna para o m�todo Read
			}
		}
		return "403";
		
	}

	/*
	 * -------------------------
	 * 			Read			
	 * -------------------------
	 *	1� Consulta Permiss�o
	 *	2� Realiza a��o no banco (ler)
	 *	3� Retorna para a p�gina JSP
	 *
	 *	@author Iuri Godoy
	 *	@return String - P�gina read (leitura)
	 */
	
	@RequestMapping("Admin/produto")
	public String read(HttpSession session, Model model) {
		
		if(Permissoes.checar(session, EnumMetodo.LER, entidade)){				//	Consulta Permiss�o
			model.addAttribute("produtos", dao.read());							//	Consulta o Banco e coloca na vari�vel da p�gina
			return "admin/Produto/read";										//	Retorna para � p�gina JSP
		}
		return "403";
		
	}
	
	/*
	 * -------------------------
	 * 			Update			
	 * -------------------------
	 *	1� Consulta Permiss�o
	 *	2� Valida
	 *	3� Realiza a��o no banco (atualizar)
	 *	4� Gera Relat�rio
	 *	5� Retorna para o m�todo READ
	 *
	 *	@author Iuri Godoy
	 *	@param Produto - O Objeto principal para a atualiza��o
	 *	@return String - Manipulado pelo Spring para o m�todo read (leitura)
	 */

	@RequestMapping("Admin/UpdateProduto")
	public String update(HttpSession session, @Valid Produto produto, BindingResult result) {
		
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta Permiss�o
			if(result.hasErrors()) {											//	Se houver erro na valida��o
			    return "forward:produto";										//	Volte
			} else {
				dao.update(produto);											//	A��o no banco
				relatorio.gerarRelatorio(session, EnumMetodo.ATUALIZAR, entidade);	//	Gera Relat�rio e armazena no banco
				return "redirect:produto";										//	Retorna para o m�todo Read
			}
		}
		return "403";
		
	}

	/*
	 * -------------------------
	 * 			Delete			
	 * -------------------------
	 *	Requisi��o AJAX
	 *
	 *	1� Consulta Permiss�o
	 *	2� Realiza a��o no banco (excluir)
	 *	3� Gera Relat�rio
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser deletado
	 *	@return void - deletar n�o precisa de um retorno
	 */
	
	@RequestMapping("Admin/DeleteProduto")
	public void delete(HttpSession session, Long id) {
		if(Permissoes.checar(session, EnumMetodo.EXCLUIR, entidade)){			//	Consulta a permiss�o
			dao.delete(id);														//	A��o no banco
			relatorio.gerarRelatorio(session, EnumMetodo.EXCLUIR, entidade);	//	Gera Relat�rio e armazena no banco
		}
	} 
	
	/*
	 * -------------------------
	 * 			Restore			
	 * -------------------------
	 *	Requisi��o AJAX
	 *
	 *	1� Consulta Permiss�o
	 *	2� Realiza a��o no banco (restaurar)
	 *	3� Gera Relat�rio
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser restaurado (ap�s ser deletado)
	 *	@return void - restaurar n�o precisa de um retorno
	 */
	
	@RequestMapping("Admin/RestoreProduto")
	public void restore(HttpSession session, Long id) {
		if(Permissoes.checar(session, EnumMetodo.RESTAURAR, entidade)){			//	Consulta a permiss�o
			dao.restore(id);													//	A��o no banco
			relatorio.gerarRelatorio(session, EnumMetodo.RESTAURAR, entidade);	//	Gera Relat�rio e armazena no banco
		}
	}


	/*
	 * -------------------------
	 * 			Find			
	 * -------------------------
	 *	Requisi��o AJAX
	 * 
	 *	1� Consulta Permiss�o
	 *	2� Realiza consulta no Banco
	 *
	 *	@author Iuri Godoy
	 *	@param id Long - id do objeto a ser deletado
	 *	@return String - retorna uma p�gina JSP
	 */
	
	@RequestMapping("Admin/FindProduto")
	public String Find(Long id, HttpSession session, Model model) {
		if(Permissoes.checar(session, EnumMetodo.ATUALIZAR, entidade)){			//	Consulta a permiss�o
			model.addAttribute("produtos", dao.findOne(id));					//	Consulta o Banco e coloca na vari�vel da p�gina
			model.addAttribute("fornecedores", forc_dao.read());				//	Consulta o Banco e coloca na vari�vel da p�gina
			model.addAttribute("categorias", cat_dao.read());					//	Consulta o Banco e coloca na vari�vel da p�gina
			return "admin/Produto/edt";											//	Retorna para a p�gina JSP edt
		}
		return"403";
	}
	
}
