package br.com.monster.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.modelDao.ImagemDao;

/*
 * @author Filipe A. Pimenta
 * @version 1.2
 * @since Release 03 do 5º semestre
 */

@Transactional
@Controller
public class ImagemController {

		@Autowired
		ImagemDao dao;
		
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
		 *	@param Imagem - O Objeto principal para a criação
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */
		
		@RequestMapping("Admin/Createimagem")
		public String create(@Valid Imagem imagem, BindingResult result) {			
			
			if(result.hasErrors()) {												//	Se houver erro na validação
			    return "forward:Produto";											//	Volte para a página produto
			} else {
				dao.create(imagem);													//	Ação no banco
				return "redirect:Produto";											//	Retorna para o método Read
			}
			
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
		 *	@param Imagem - O Objeto principal para a atualização
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */

		@RequestMapping("Admin/Updateimagem")
		public String update(@Valid Imagem imagem, BindingResult result) {

			if(result.hasErrors()) {												//	Se houver erro na validação
			    return "forward:Produto";											//	Volte
			} else {
				dao.update(imagem);													//	Ação no banco
				return "redirect:Produto";											//	Retorna para o método Read
			}
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 *	Requisição AJAX
		 *
		 *	1º Realiza ação no banco (excluir)
		 *	2º Retorna para o método READ
		 *
		 *	@author Filipe A. Pimenta
		 *	@param id Long - id do objeto a ser deletado
		 *	@return String - Manipulado pelo Spring para o método read (leitura)
		 */
		
		@RequestMapping("Admin/Deleteimagem")
		public String delete(Long id) {
		  dao.delete(id);															//	Ação no banco
		  return "redirect:Produto";												//	Retorna para o método Read
		}

}
