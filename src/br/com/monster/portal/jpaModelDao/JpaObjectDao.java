package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JpaObjectDao {
	
	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
	
	String nome_objeto;
	String nome_id_objeto;
	
	/*

	List<Object> Read() {
    	Query query = manager
		        .createQuery("SELECT pro "
		        		+ "FROM Produto pro "
		        		+ "ORDER BY pro.nome_pro ");

		@SuppressWarnings("unchecked")
		List<Object> objetos = query.getResultList();

		return objetos;
	}
	
	void create(Object object){
		
	}
	
	void update(Object object){
		object.setUpdated_at(cal.getTime());
		manager.merge(object);
	}*/
	
	Object findOne(Long id) {
		Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.nome_pro = :Id "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) ");
			
			query.setParameter("Id", id);
	
			Object objects = (Object) query.getResultList();
	
			return objects;
	}
	
	void delete(Long id){
		   Date datetime = cal.getTime();
		   
		   Query query = manager
				   .createQuery("UPDATE :Objeto obj "
				   				+ "SET obj.deleted = true, "
				   				+ "obj.deleted_at = :Deleted_at "
								+ "WHERE obj.:nome_id_objeto = :id");
		   
			query.setParameter("Objeto", nome_objeto);					//	
			query.setParameter("nome_id_objeto", nome_id_objeto);		//	
			query.setParameter("Deleted_at", datetime);					//	
			query.setParameter("id", id);								//	
			query.executeUpdate();
	}
	
	void restore(Long id){
		   Query query = manager
				   .createQuery("UPDATE :Objeto obj "
				   				+ "SET obj.deleted = false "
								+ "WHERE obj.:nome_id_objeto = :id");
		   
			query.setParameter("Objeto", nome_objeto);					//	
			query.setParameter("nome_id_objeto", nome_id_objeto);		//	
			query.setParameter("id", id);								//	
			query.executeUpdate();
	}
}
