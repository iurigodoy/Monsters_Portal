package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.model.Produto_has_fornecedor;
import br.com.monster.portal.modelDao.ProdutoDao;



// Container do Spring
@Repository
public class JpaProdutoDao implements ProdutoDao {

	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	   
	   /*
	    * ----------------------------------
	    *			M�todo Read				
	    * ----------------------------------
	    * 
	    * A seguir m�todos de pesquisa
	    * 
	    */
		public List<Produto> Read() {
		
			
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT pro FROM Imagem ima WHERE ordem_ima = 1) "
			        		+ "ORDER BY pro.nome_pro ");

			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();

			return produtos;
		}
		public List<Produto> Read_publico() {
			
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

		public List<Produto> Read_destacado() {
			
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
	    * ----------------------------------
	    *			M�todo Find_One			
	    * ----------------------------------
	    * 
	    */

		   
		public Produto findOne(Long id) {

			Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Produto pro "
				        		+ "WHERE pro.nome_pro = :Id "
				        		+ "AND pro.id_produto IN "
				        		+ "(SELECT produto FROM Imagem ima) ");
				
				query.setParameter("Id", id);
		
				Produto produtos = (Produto) query.getResultList();
		
				return produtos;
				
			}
	   
	   public List<Produto> Find_By_Name(String nome_prod) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.nome_pro LIKE :Nome "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) ");
			
			query.setParameter("Nome", (String) "%"+nome_prod+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
<<<<<<< HEAD
		public Produto_has_fornecedor findOnePublic(Long id) {

			boolean gambiarraAQUI;	// Usando o alert do eclipse para mostrar a gambiarra pro prox programador arrumar!
			
			/*
			 * Chamando entidade intermedi�ria de
			 *		Produto e Fornecedor
			 *
			 *	Gambiarra feita para n�o fazer o
			 *		OpenSessionInView
			 *
			
			/*Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		
			        		//+ "WHERE pro.id_produto IN "
			        		//+ "(SELECT pro FROM Produto_has_fornecedor prod_forn) "
			        		
			        		//+ "WHERE prod_forn.fornecedor.id_fornecedor IN "
			        		//+ "(SELECT prod_forn FROM Fornecedor forn)) "
			        		
			        		+ "WHERE pro.publicado_pro = true "
			        		+ "AND pro.deleted = false "
			        		
			        		+ "AND pro.id_produto = :Id"); return Produto produto;*/
			
			Query query = manager
			        .createQuery("SELECT prod_forn "
			        		+ "FROM Produto_has_fornecedor prod_forn "
			        		
			        		+ "WHERE prod_forn.produto.id_produto IN "
			        		+ "(SELECT prod_forn FROM Produto prod "
			        		+ "WHERE prod.publicado_pro = true "
			        		+ "AND prod.deleted = false) "
			        		
			        		+ "AND prod_forn.produto.id_produto = :Id");
			
			query.setParameter("Id", id);
	
			Produto_has_fornecedor produto = (Produto_has_fornecedor) query.getSingleResult();
	
			return produto;
			
		}

		public List<Produto> FindProdutoPorCategoria(Long id) {
=======
		@Override
		public List<Produto> Find_publico(String nome_produto) {
>>>>>>> parent of f45fb1a... Versão do Semestre Passado

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
<<<<<<< HEAD
			        		
			        		+ "WHERE pro.publicado_pro = true "
			        		+ "AND pro.deleted = false "
			        		+ "AND pro.categoria.id_categoria = :Id");
=======
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_pro = true "
			        		+ "AND pro.nome_pro = :Nome");
>>>>>>> parent of f45fb1a... Versão do Semestre Passado
			
			query.setParameter("Nome", (String) nome_produto);
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
<<<<<<< HEAD
		public List<Produto> FindManyPublic(String nome_produto) {
=======
		@Override
		public List<Produto> Find_Many_publico(String nome_produto) {
>>>>>>> parent of f45fb1a... Versão do Semestre Passado

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.nome_pro LIKE :Nome");
			
			query.setParameter("Nome", (String) "%"+nome_produto+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Produto produto, ImagemMultiple imagens) {
			produto.setCreated_at(cal.getTime());
			produto.setUpdated_at(cal.getTime());
			produto.setDeleted(false);
			
			manager.persist(produto);
			manager.flush();	// Manter a sess�o aberta
			// Pega o Id do �ltimo dado inserido
				produto.getId_produto();
				
				// Checa se o array est� correto e faz o la�o de repeti��o
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
	    * ----------------------------------
	    *			M�todo Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Produto produto) {
			produto.setUpdated_at(cal.getTime());
			manager.merge(produto);
		}
	   
	   /*
	    * ----------------------------------
	    *			M�todo Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Long id) {
		   
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE Produto pro "
				   				+ "SET pro.deleted = true, "
				   				+ "pro.deleted_at = :Deleted_at "
   								+ "WHERE pro.id_produto = :id");
			query.setParameter("Deleted_at", datetime);
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	   
	   /*
	    * ----------------------------------
	    *			M�todo Restore			
	    * ----------------------------------
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
	   
}
