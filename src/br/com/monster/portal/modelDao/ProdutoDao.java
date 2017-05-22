package br.com.monster.portal.modelDao;

import java.util.List;

import br.com.monster.portal.model.FornecedorMultiple;
import br.com.monster.portal.model.ImagemMultiple;
import br.com.monster.portal.model.Produto;

/*
 * @author Iuri Godoy
 * @version 2
 * @since Release 03 do 5º semestre
 */

public interface ProdutoDao extends MetodosBasicos {

	List<Produto> read();
	List<Produto> read_publico();
	List<Produto> read_destacado();
	List<Produto> findByName(String nome_prod);
	List<Produto> find_produto_cat(Long id);
	
	Produto findOnePublic(Long id);
	
	void create(Produto produto, ImagemMultiple imagens, FornecedorMultiple fornecedor);
	void update(Produto produto);
}