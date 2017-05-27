package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "imagem")
public class Imagem {
	
	@Id
	@GeneratedValue
	private Long id_imagem;
	
	@Column(name = "ima_ordem")			//Nome real dentro do banco
	private Integer ordem_ima;			//Nome do campo no sistema
	
	@NotNull(message="{ima.arquivo.NotEmpty}")
	@Size(min=2, max=100, message = "{ima.arquivo.Size}")
	@Column(name = "ima_arquivo", unique=true)			//Nome real dentro do banco
	private String arquivo_ima;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	// MUITOS Ramais est�o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_imagem() {
		return id_imagem;
	}

	public void setId_imagem(Long id_imagem) {
		this.id_imagem = id_imagem;
	}

	public Integer getOrdem_ima() {
		return ordem_ima;
	}

	public void setOrdem_ima(Integer ordem_ima) {
		this.ordem_ima = ordem_ima;
	}

	public String getArquivo_ima() {
		return arquivo_ima;
	}

	public void setArquivo_ima(String arquivo_ima) {
		this.arquivo_ima = arquivo_ima;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
