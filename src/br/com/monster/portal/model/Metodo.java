package br.com.monster.portal.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "metodo")
public class Metodo {
	
	@Id
	@GeneratedValue
	private Long id_metodo;
	
	@NotNull(message="{metodo.nome.NotEmpty}")
	@Size(min=2, max=50, message = "{metodo.nome.Size}")
	@Column(name = "metd_nome")			//Nome real dentro do banco
	private String nome_metd;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="metodo", fetch=FetchType.EAGER)
	private Set<Relatorio> relatorio;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_metodo() {
		return id_metodo;
	}

	public void setId_metodo(Long id_metodo) {
		this.id_metodo = id_metodo;
	}

	public String getNome_metd() {
		return nome_metd;
	}

	public void setNome_metd(String nome_metd) {
		this.nome_metd = nome_metd;
	}

	public Set<Relatorio> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Set<Relatorio> relatorio) {
		this.relatorio = relatorio;
	}
	
	
}
