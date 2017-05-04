package br.com.monster.portal.jpaModelDao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

<<<<<<< HEAD:src/br/com/monster/portal/jpaModelDao/JpaRelatorioDao.java
import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.model.Relatorio;
import br.com.monster.portal.modelDao.RelatorioDao;
import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;
=======
import br.com.monster.portal.model.Relatorios;
import br.com.monster.portal.modelDao.RelatoriosDao;
>>>>>>> parent of f45fb1a... VersÃ£o do Semestre Passado:src/br/com/monster/portal/jpaModelDao/JpaRelatoriosDao.java

@Repository
public class JpaRelatoriosDao implements RelatoriosDao {

	@PersistenceContext
	EntityManager manager;
	
	//Pegar a hora
	Calendar cal = new GregorianCalendar();
<<<<<<< HEAD:src/br/com/monster/portal/jpaModelDao/JpaRelatorioDao.java
	
	//	Gerar Relatório do Funcionario que utilizou um metodo em uma entidade
	//	Exemplo: Gerar Relatório do Iuri Godoy (Funcionario) que alterou (Metodo) um produto (Entidade)
	public void gerarRelatorio(HttpSession session, EnumMetodo metodo, EnumEntidade entidade){
		// Pega o funcionario da sessão
		Funcionario funcionario = (Funcionario) session.getAttribute("administradorLogado");
		// Gera o relatorio
		Relatorio relatorio = new Relatorio();
		// Popula o relatorio
		relatorio.setFuncionario(funcionario);
		relatorio.setMetodo(metodo);
		relatorio.setEntidade(entidade);
		relatorio.setCreated_at(cal.getTime());
		// Insere no banco
		manager.persist(relatorio);
	}

	@Override
	public List<Relatorio> Read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relatorio Find_One(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
=======
	   
	   /*
	    * ----------------------------------
	    *			Mï¿½todo Read				
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de pesquisa
	    * 
	    */
		public List<Relatorios> Read() {
			
				/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
	    	Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Relatorios pro "
			        		+ "WHERE pro.deleted = false "
			        		+ "ORDER BY pro.id_relatorios ASC");

			@SuppressWarnings("unchecked")
			List<Relatorios> relatorios = query.getResultList();

			return relatorios;
		}
	   
	   /*
	    * ----------------------------------
	    *			Mï¿½todo Find_One			
	    * ----------------------------------
	    * 
	    */
	   
	   public Relatorios Find_One(Long id){
			
	    	Query query = manager
			        .createQuery("SELECT relatorios "//16
			        		+ "FROM Relatorios relatorios "
			        		+ "WHERE relatorios.id_relatorios = :Id");
	    	
			query.setParameter("Id", id);

			Relatorios relatorios = (Relatorios) query.getSingleResult();
			
		   return relatorios;
	   }
	   
	   
	   
	   
	
	   /*
	    * ----------------------------------
	    *			Mï¿½todo Create			
	    * ----------------------------------
	    * 
	    * A seguir mï¿½todos de alteraï¿½ï¿½o
	    * 
	    */
		public void create(Relatorios relatorios) {
			relatorios.setCreated_at(cal.getTime());
			 manager.persist(relatorios);
	    }
	   
>>>>>>> parent of f45fb1a... VersÃ£o do Semestre Passado:src/br/com/monster/portal/jpaModelDao/JpaRelatoriosDao.java
}
