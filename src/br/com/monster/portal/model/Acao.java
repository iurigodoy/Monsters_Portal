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
@Table(name = "acao")
public class Acao {
	
	@Id
	@GeneratedValue
	private Long id_acao;
	
	@NotNull(message="{acao.nome.NotEmpty}")
	@Size(min=2, max=50, message = "{acao.nome.Size}")
	@Column(name = "acao_nome")			//Nome real dentro do banco
	private String nome_acao;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="acao", fetch=FetchType.EAGER)
	private Set<Relatorios> relatorios;
		
	@OneToMany(mappedBy="acao", fetch=FetchType.EAGER)
	private Set<Permissao> permissoes;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public Long getId_acao() {
		return id_acao;
	}

	public void setId_acao(Long id_acao) {
		this.id_acao = id_acao;
	}

	public String getNome_acao() {
		return nome_acao;
	}

	public void setNome_acao(String nome_acao) {
		this.nome_acao = nome_acao;
	}

	public Set<Relatorios> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(Set<Relatorios> relatorios) {
		this.relatorios = relatorios;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
