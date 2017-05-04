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
@Table(name = "processos")
public class Processos {
	
	@Id
	@GeneratedValue
	private Long id_processos;
	
	@NotNull(message="{proc.nome.NotEmpty}")
	@Size(min=2, max=50, message = "{proc.nome.Size}")
	@Column(name = "proc_nome")			//Nome real dentro do banco
	private String nome_proc;			//Nome do campo no sistema

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="processos", fetch=FetchType.EAGER)
	private Set<Relatorios> relatorios;
	
	@OneToMany(mappedBy="processos", fetch=FetchType.EAGER)
	private Set<Permissao> permissoes;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_processos() {
		return id_processos;
	}

	public void setId_processos(Long id_processos) {
		this.id_processos = id_processos;
	}

	public String getNome_proc() {
		return nome_proc;
	}

	public void setNome_proc(String nome_proc) {
		this.nome_proc = nome_proc;
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
