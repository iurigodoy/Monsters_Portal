package br.com.monster.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissoes")
public class Permissoes {
	
	@Id
	@GeneratedValue
	private Long id_permissoes;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais estão em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "acao_id_acao", insertable=true, updatable=true)
	private Acao acao;
	
	@ManyToOne
	@JoinColumn(name = "processos_id_processos", insertable=true, updatable=true)
	private Processos processos;

	@ManyToOne
	@JoinColumn(name = "cargo_id_cargo", insertable=true, updatable=true)
	private Cargo cargo;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_permissoes() {
		return id_permissoes;
	}

	public void setId_permissoes(Long id_permissoes) {
		this.id_permissoes = id_permissoes;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Processos getProcessos() {
		return processos;
	}

	public void setProcessos(Processos processos) {
		this.processos = processos;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
