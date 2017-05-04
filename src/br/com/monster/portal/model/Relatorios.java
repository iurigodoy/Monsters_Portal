package br.com.monster.portal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.monster.portal.security.EnumEntidade;
import br.com.monster.portal.security.EnumMetodo;

@Entity
@Table(name = "relatorios")
public class Relatorios {

	@Id
	@GeneratedValue
	private Long id_relatorios;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais est�o em UM Setor	(N-1)
<<<<<<< HEAD:src/br/com/monster/portal/model/Relatorio.java
	//@ManyToOne
	//@JoinColumn(name = "entidade_id_entidade", insertable=true, updatable=true)
	private EnumEntidade entidade;
	
	//@ManyToOne
	//@JoinColumn(name = "metodo_id_metodo", insertable=true, updatable=true)
	private EnumMetodo metodo;
=======
	@ManyToOne
	@JoinColumn(name = "processos_id_processos", insertable=true, updatable=true)
	private Processos processos;
	
	@ManyToOne
	@JoinColumn(name = "acao_id_acao", insertable=true, updatable=true)
	private Acao acao;
>>>>>>> parent of f45fb1a... Versão do Semestre Passado:src/br/com/monster/portal/model/Relatorios.java
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id_funcionario", insertable=true, updatable=true)
	private Funcionario funcionario;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_relatorios() {
		return id_relatorios;
	}

	public void setId_relatorios(Long id_relatorios) {
		this.id_relatorios = id_relatorios;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

<<<<<<< HEAD:src/br/com/monster/portal/model/Relatorio.java
	public EnumEntidade getEntidade() {
		return entidade;
	}

	public void setEntidade(EnumEntidade entidade) {
		this.entidade = entidade;
	}

	public EnumMetodo getMetodo() {
		return metodo;
	}

	public void setMetodo(EnumMetodo metodo) {
		this.metodo = metodo;
=======
	public Processos getProcessos() {
		return processos;
	}

	public void setProcessos(Processos processos) {
		this.processos = processos;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
>>>>>>> parent of f45fb1a... Versão do Semestre Passado:src/br/com/monster/portal/model/Relatorios.java
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
