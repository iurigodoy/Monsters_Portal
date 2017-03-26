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
	    *			Método Read				
	    * ----------------------------------
	    * 
	    * A seguir métodos de pesquisa
	    * 
	    */
		public List<Produto> Read() {
		
			
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_produto "
							+ "(SELECT produto FROM Imagem ima)");

			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();

			return produtos;
		}
		public List<Produto> Read_publico() {
			
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true");
		    	

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

			return produtos;
		}

		public List<Produto> Read_destacado() {
			
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.destaque_produto = true");
		    	

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

			return produtos;
		}
		   
		/*
		*	Método Read	History			
		*/
		public List<Produto> Read_History() {
			
	    	Query query = manager
			        .createQuery("SELECT pro "
				        		+ "FROM Produto pro "
				        		+ "ORDER BY pro.id_produto "
								+ "(SELECT produto FROM Imagem ima) ");

			@SuppressWarnings("unchecked")
			List<Produto> produtos = query.getResultList();

			return produtos;
		}
		   
		/*
		 * ----------------------------------
		 *			Select Name And ID	
		 * ----------------------------------
		 * 
		 */
			public List<Produto> Select_Name_Id() {
				
		    	Query query = manager
				        .createQuery("SELECT pro.id_produto, pro.pro_nome "//16
				        		+ "FROM Produto pro "
				        		+ "WHERE pro.deleted = false "
				        		+ "ORDER BY pro.id_produto");

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

				return produtos;
			}
	   
	   /*
	    * ----------------------------------
	    *			Método Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public List<Produto> Find_By_Name(String nome_prod) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.nome_produto LIKE :Nome "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) ");
			
			query.setParameter("Nome", (String) "%"+nome_prod+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
		@Override
		public List<Produto> Find_publico(String nome_produto) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.nome_produto = :Nome");
			
			query.setParameter("Nome", (String) nome_produto);
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
		@Override
		public List<Produto> Find_Many_publico(String nome_produto) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.nome_produto LIKE :Nome");
			
			query.setParameter("Nome", (String) "%"+nome_produto+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    * A seguir métodos de alteração
	    * 
	    */
		public void create(Produto produto, ImagemMultiple imagens) {
			produto.setCreated_at(cal.getTime());
			produto.setUpdated_at(cal.getTime());
			produto.setDeleted(false);
			
			manager.persist(produto);
			manager.flush();	// Manter a sessão aberta
			// Pega o Id do último dado inserido
				produto.getId_produto();
				
				// Checa se o array está correto e faz o laço de repetição
				if(null != imagens.getImagens() && imagens.getImagens().size() > 0) {
					for (Imagem imagem : imagens.getImagens()) {
						
						// Segundo o Hibernate é necessário atualizar o objeto e pegar seu id novamente
						manager.merge(produto);
						manager.flush();
						
						imagem.setProduto(produto);
						
						manager.persist(imagem);
						
					}
				}
	    }

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Produto produto) {
			produto.setUpdated_at(cal.getTime());
			manager.merge(produto);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
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
	    *			Método Restore			
	    * ----------------------------------
	    * 
	    */

	   public void restore(Long id) {
		   
		   Query query = manager
				   .createQuery("UPDATE Produto produto "
				   				+ "SET pro.deleted = false "
   								+ "WHERE pro.id_produto = :id");
			query.setParameter("id", id);
			query.executeUpdate();
	   }
	@Override
	public Produto Find_One(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	   
}
