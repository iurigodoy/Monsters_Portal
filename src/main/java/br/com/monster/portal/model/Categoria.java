package br.com.monster.portal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria extends Historico {
	
	@Id
	@GeneratedValue
	private Long id_categoria;
	
	@NotNull(message="{cat.nome.NotEmpty}")
	@Size(min=2, max=100, message = "{cat.nome.Size}")
	@Column(name = "cat_nome")
	private String nome_cat;
	
	@Column(name = "cat_hierarquia")
	private Integer hierarquia_cat;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="categoria")
	private List<Produto> produto;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome_cat() {
		return nome_cat;
	}

	public void setNome_cat(String nome_cat) {
		this.nome_cat = nome_cat;
	}

	public Integer getHierarquia_cat() {
		return hierarquia_cat;
	}

	public void setHierarquia_cat(Integer hierarquia_cat) {
		this.hierarquia_cat = hierarquia_cat;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}
