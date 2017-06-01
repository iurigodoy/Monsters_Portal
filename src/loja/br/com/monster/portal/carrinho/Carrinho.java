package br.com.monster.portal.carrinho;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.monster.portal.frete.Frete;
import br.com.monster.portal.frete.ListaFrete;
import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.model.Produto;

public class Carrinho {

	  private List<Item> itens = new ArrayList<Item>();
	  
	  private Double valorFrete = 0.00;
	  
	  private Integer prazoEntrega;
	  
	  private Double total = 0.00;
	  
	  public void adiciona(Item item) {
		// Verificar também se ele já não está na lista
	    itens.add(item);
	    Double preco = item.getProduto_has_fornecedor().getPreco_prod();
	    total += item.getProduto_has_fornecedor().getProduto().calcularDesconto(preco) * item.getQuantidade();
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
	  
	public void frete(HttpSession session, Item item){
		Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
		if(cliente != null){
		  if(cliente.getCep_cli() != null){
			Fornecedor fornecedor = item.getProduto_has_fornecedor().getFornecedor();
			Produto produto = item.getProduto_has_fornecedor().getProduto();
			
			ListaFrete frete = Frete.consultaFrete(cliente, fornecedor, produto);
			valorFrete = frete.converterValorDouble(frete.getValor());
			prazoEntrega = frete.converterPrazoInteger(frete.getPrazoEntrega());
		  }
		}
	}
	
	public Double totalComFrete(){
		return valorFrete + total;
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

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

}
