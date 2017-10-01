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
@Table(name = "banner")
public class Banner extends Historico {
	
	@Id
	@GeneratedValue
	private Long id_banner;
	
	@NotNull(message="{ban.arquivo.NotEmpty}")
	@Size(min=2, max=100, message = "{ban.arquivo.Size}")
	@Column(name = "ban_arquivo", unique=true)
	private String arquivo;
	
	@Column(name = "ban_ativo")
	private Boolean ativo;

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

	public Long getId_banner() {
		return id_banner;
	}

	public void setId_banner(Long id_banner) {
		this.id_banner = id_banner;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
