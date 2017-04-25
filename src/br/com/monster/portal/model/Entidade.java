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
@Table(name = "entidade")
public class Entidade {
	
	@Id
	@GeneratedValue
	private Long id_entidade;
	
	@NotNull(message="{ent.nome.NotEmpty}")
	@Size(min=2, max=50, message = "{proc.nome.Size}")
	@Column(name = "ent_nome")			//Nome real dentro do banco
	private String nome_ent;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	@OneToMany(mappedBy="entidade", fetch=FetchType.EAGER)
	private Set<Relatorio> relatorio;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_entidade() {
		return id_entidade;
	}

	public void setId_entidade(Long id_entidade) {
		this.id_entidade = id_entidade;
	}

	public String getNome_ent() {
		return nome_ent;
	}

	public void setNome_ent(String nome_ent) {
		this.nome_ent = nome_ent;
	}

	public Set<Relatorio> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Set<Relatorio> relatorio) {
		this.relatorio = relatorio;
	}
	
}
