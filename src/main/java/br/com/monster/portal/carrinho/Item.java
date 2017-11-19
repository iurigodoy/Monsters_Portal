package br.com.monster.portal.carrinho;

import br.com.monster.portal.model.Produto_has_fornecedor;

public class Item {

	  private Produto_has_fornecedor produto_has_fornecedor;
	  
	  private Integer quantidade;
	  
	// getters e setters
	
	public Produto_has_fornecedor getProduto_has_fornecedor() {
		return produto_has_fornecedor;
	}

	public void setProduto_has_fornecedor(Produto_has_fornecedor produto_has_fornecedor) {
		this.produto_has_fornecedor = produto_has_fornecedor;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
