package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		public List<Produto> read() {
		
			
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
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			M�todo Create			
	    * ----------------------------------
	    * 
	    * A seguir m�todos de altera��o
	    * 
	    */
		public void create(Produto produto, ImagemMultiple imagens, FornecedorMultiple fornecedores) {
			
			boolean error; // n�o esque�a de colocar os fornecedores
			
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
