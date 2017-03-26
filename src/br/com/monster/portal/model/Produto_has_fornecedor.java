package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto_has_fornecedor")
public class Produto_has_fornecedor {
	
	@NotNull(message="{prod.quantidade.NotEmpty}")
	@Column(name = "prod_quantidade")			//Nome real dentro do banco
	private Integer quantidade_prod;			//Nome do campo no sistema
	
	@NotNull(message="{prod.preco.NotEmpty}")
	@Column(name = "prod_preco")			//Nome real dentro do banco
	private Float preco_prod;			//Nome do campo no sistema
	
	@Column(name = "prod_garantia")			//Nome real dentro do banco
	private Integer garantia_prod;			//Nome do campo no sistema

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
	@JoinColumn(name = "fornecedor_id_fornecedor", insertable=true, updatable=true)
	private Fornecedor fornecedor;
	
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

	public Float getPreco_prod() {
		return preco_prod;
	}

	public void setPreco_prod(Float preco_prod) {
		this.preco_prod = preco_prod;
	}

	public Integer getGarantia_prod() {
		return garantia_prod;
	}

	public void setGarantia_prod(Integer garantia_prod) {
		this.garantia_prod = garantia_prod;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
