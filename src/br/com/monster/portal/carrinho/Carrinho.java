package br.com.monster.portal.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	  private List<Item> itens = new ArrayList<Item>();
	  
	  private Double total = 0.0;
	  
	  public void adiciona(Item item) {
	    itens.add(item);
	    total += item.getProduto_do_fornecedor().getPreco_prod() * item.getQuantidade();
	  }
	  
	  public Integer getTotalDeItens() {
	    return itens.size();
	  }
	  
	  public void remove(int indiceItem) {
	    Item removido = itens.remove(indiceItem);
	    total -= removido.getProduto_do_fornecedor().getPreco_prod() * removido.getQuantidade();
	  }

}
