package br.com.monster.portal.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	  private List<Item> itens = new ArrayList<Item>();
	  
	  private Double total = 0.0;
	  
	  public void adiciona(Item item) {
		// Verificar também se ele já não está na lista
	    itens.add(item);
	    total += item.getProduto_has_fornecedor().getPreco_prod() * item.getQuantidade();
	  }
	  
	  public Integer getTotalDeItens() {
	    return itens.size();
	  }
	  
	  public void remove(int indiceItem) {
	    Item removido = itens.remove(indiceItem);
	    total -= removido.getProduto_has_fornecedor().getPreco_prod() * removido.getQuantidade();
	  }
	  
	public void removeAll(){
		itens.removeAll(itens);
		total = 0.00;
	}
	  
	  //ggas

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

}
