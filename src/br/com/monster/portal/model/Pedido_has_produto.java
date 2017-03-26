package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido_has_produto")
public class Pedido_has_produto {
	
	@NotNull(message="{prod.quantidade.NotEmpty}")
	@Column(name = "prod_quantidade")			//Nome real dentro do banco
	private Integer quantidade_prod;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
			
	@ManyToOne
	@JoinColumn(name = "pedido_id_pedido", insertable=true, updatable=true)
	private Pedido pedido;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Integer getQuantidade_prod() {
		return quantidade_prod;
	}

	public void setQuantidade_prod(Integer quantidade_prod) {
		this.quantidade_prod = quantidade_prod;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
