package br.com.monster.portal.jpaModelDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import JpaUtil.JpaResultHelper;
import br.com.monster.portal.model.Produto_has_fornecedor;
import br.com.monster.portal.modelDao.Produto_has_fornecedorDao;



// Container do Spring
@Repository
public class JpaProduto_has_fornecedorDao implements Produto_has_fornecedorDao {

	
	@PersistenceContext
	EntityManager manager;

	public Produto_has_fornecedor recarrega(Long id_prod, Long id_forn) {
		
		Query query = manager
		        .createQuery("SELECT pro "
		        		+ "FROM Produto_has_fornecedor pro "
		        		+ "WHERE pro.produto.id_produto = :Id_prod "
		        		+ "AND pro.fornecedor.id_fornecedor = :Id_forn "
		        		
		        		+ "AND pro.produto IN "
		        		+ "(SELECT pro FROM Produto prod "
		        		+ "WHERE prod.id_produto IN "
		        		+ "(SELECT prod FROM Imagem ima WHERE ima.ordem_ima = 1))");
		
		query.setParameter("Id_prod", (long) id_prod);
		query.setParameter("Id_forn", (long) id_forn);
	    	

			Produto_has_fornecedor produtos = (Produto_has_fornecedor) query.getSingleResult();

		return produtos;
	}
	
	public Produto_has_fornecedor findOnePublic(Long id){
		
		Query query = manager
		        .createQuery("SELECT pro "
		        		+ "FROM Produto_has_fornecedor pro "
		        		+ "WHERE pro.produto.id_produto = :Id ");
		
		query.setParameter("Id", id);

		Produto_has_fornecedor produto = (Produto_has_fornecedor) JpaResultHelper.getSingleResultOrNull(query);

		return produto;
	}
	   
}
