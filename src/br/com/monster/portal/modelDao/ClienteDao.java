package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.Cliente;

public interface ClienteDao {
	
	List<Cliente> Read();
	Cliente Find_One(long id);
	Cliente SeUsuarioExiste(Cliente cliente);
	boolean UsuarioExiste(Cliente cliente);
	
	void create(Cliente cliente);
	void update(Cliente cliente);
	void delete(Long id);
	void restore(Long id);
	
}