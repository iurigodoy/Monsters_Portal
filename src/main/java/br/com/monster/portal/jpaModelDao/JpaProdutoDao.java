package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.FornecedorMultiple;
import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.ProdutoDao;

/*
 * @author Iuri Godoy
 * @version 2
 * @since Release 03 do 5º semestre
 * 
 * Implementa o padrão CRUD com dois
 * métodos adicionais que chamamos de
 * restore e find.
 * 
 * O JpaEntidadeDao é um padrão definido
 * para o desenvolvimento desse sistema,
 * onde essas classes apenas falam com o
 * banco de maneira simples, através ou
 * não de HQLs.
 * 
 */

// Container do Spring
@Repository
public class JpaProdutoDao implements ProdutoDao {
	
	@PersistenceContext
	EntityManager manager;
	   
		/*
		 * -------------------------
		 * 			Create			
		 * -------------------------
		 *
		 *	@author Iuri Godoy
		 *	@param Produto - O Objeto principal para a criação
		 *	@param ImagemMultiple - Podem ser inseridas multiplas imagens para um produto
		 *	@param FornecedorMultiple - Podem ser inseridos multiplos fornecedores para um produto
		 *	@return void - criar não precisa de um retorno
		 *
		 *  1º Insere a data de criação e atualização
		 *  2º Persiste no banco de dados
		 *  
		 */
		
		public void create(Produto produto, ImagemMultiple imagens, FornecedorMultiple fornecedores) {
			
			boolean error; // TODO n�o esque�a de colocar os fornecedores
			
			produto.criarHistorico();
			
			manager.persist(produto);
			manager.flush();
			
				produto.getId_produto();
				
				if(null != imagens.getImagens() && imagens.getImagens().size() > 0) {
					for (Imagem imagem : imagens.getImagens()) {
						
						// Segundo o Hibernate � necess�rio atualizar o objeto e pegar seu id novamente
						manager.merge(produto);
						manager.flush();
						
						imagem.setProduto(produto);
						
						manager.persist(imagem);
						
					}
				}
	    }
		
		/*
		 * -------------------------
		 * 			Read (3)		
		 * -------------------------
		 *
		 *	@author Iuri Godoy
		 *	@return List<Object> - Retorna uma lista de Objetos
		 *
		 *	1º Realiza o select via HQL
		 *  2º Coloca o resultado numa List
		 *  
		 */
	
		public List<Object> read() {
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT pro FROM Imagem ima WHERE ordem_ima = 1) "
			        		+ "ORDER BY pro.nome_pro ");
	    	
			@SuppressWarnings("unchecked")
			List<Object> produtos = query.getResultList();
			return produtos;
		}
		
		public List<Produto> read_publico() {
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT pro FROM Imagem ima WHERE ordem_ima = 1) "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT pro FROM Produto_has_fornecedor pro_for) "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.deleted = false");
			
			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();
			return produtos;
		}

		public List<Produto> read_destacado() {
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT pro FROM Imagem ima WHERE ordem_ima = 1) "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT pro FROM Produto_has_fornecedor pro_for) "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.destaque_pro = true "
			        		+ "AND pro.deleted = false");

			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();
			return produtos;
		}

		/*
		 * -------------------------
		 * 			Update			
		 * -------------------------
		 * 
		 *	@author Iuri Godoy
		 *	@param Objeto - O Objeto principal para a atualização
		 *	@return void - atualizar não precisa de um retorno
		 *
		 *  1º Insere a data de atualização
		 *	2º Dá um merge (atualiza)
		 *
		 */
		
		public void update(Object object) {
			Produto produto = (Produto) object;
			produto.atualizarHistorico();
			manager.merge(produto);
		}

		/*
		 * -------------------------
		 * 			Delete			
		 * -------------------------
		 *
		 *	@author Iuri Godoy
		 *	@param id Long - id do objeto a ser deletado
		 *	@return void - deletar não precisa de um retorno
		 *
		 *	1º Pega a data
		 *	2º Escreve a HQL, onde o objeto é atualizado para deletado e inserida uma data de deletado
		 *	3º Insere o Parâmetro Id e a data em que foi deletado
		 *	4º Executa a Query
		 *
		 */

	   public void delete(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Produto pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_produto = :id");
			query.setParameter("Deleted_at", Calendar.getInstance());
			query.setParameter("id", id);
			query.executeUpdate();
	   }
		
		/*
		 * -------------------------
		 * 			Restore			
		 * -------------------------
		 *
		 *	@author Iuri Godoy
		 *	@param id Long - id do objeto a ser restaurado (após ser deletado)
		 *	@return void - restaurar não precisa de um retorno
		 *
		 *	1º Escreve a HQL, onde o objeto é atualizado para não deletado,
		 *	mas mantém a data da última vez que foi deletado
		 *	2º Insere o Parâmetro Id
		 *	3º Executa a Query
		 *
		 */

	   public void restore(Long id) {
		   Query query = manager
				   .createQuery("UPDATE Produto pro "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_produto = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }

		/*
		 * -------------------------
		 * 			Find (4)		
		 * -------------------------
		 *
		 *	@author Iuri Godoy
		 *	@param id Long - id do objeto a ser deletado
		 *	@return Object - retorna um único objeto
		 *
		 *	1º Constroi a HQL
		 *	2º Insere o parâmetro Id
		 *	3º Coloca os dados no Objeto
		 *
		 */
			   
		public Produto findOne(Long id) {
			Query query = manager
				.createQuery("SELECT pro "
							+ "FROM Produto pro "
							+ "WHERE pro.id_produto = :Id ");
			query.setParameter("Id", id);
			
			Produto produto = (Produto) query.getSingleResult();
			return produto;
		}
		
		public Produto findOnePublic(Long id) {
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.deleted = false "
			        		+ "AND pro.id_produto = :Id");
			query.setParameter("Id", id);
	
			Produto produto = (Produto) query.getSingleResult();
			return produto;
		}
		
		public List<Produto> findByName(String nome_produto) {
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.nome_pro LIKE :Nome");
			query.setParameter("Nome", (String) "%"+nome_produto+"%");
	
			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();
			return produtos;
		}
		
		public List<Produto> find_produto_cat(Long id) {
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.categoria.id_categoria = :Id "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.deleted = false ");
			query.setParameter("Id", id);

			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();
			return produtos;
		}

		public void create(Object object) {
			// TODO Auto-generated method stub
		}
}
