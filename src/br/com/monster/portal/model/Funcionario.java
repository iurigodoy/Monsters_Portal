package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.monster.portal.security.Crypt;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Historico {
	
	@Id
	@GeneratedValue
	private Long id_funcionario;
	
	@NotNull(message="{fun.nome.NotEmpty}")
	@Size(min=3, max=200, message = "{fun.nome.Size}")
	@Column(name = "fun_nome")
	private String nome_fun;
	
	@NotNull(message="{fun.cpf.NotEmpty}")
	@Column(name = "fun_cpf", unique=true)
	private String cpf_fun;
	
	
	@Column(name = "fun_bloqueado")
	private Boolean bloqueado_fun;
	
	@NotNull(message="{fun.foto.NotEmpty}")
	@Size(min=1, max=100, message = "{fun.foto.Size}")
	@Column(name = "fun_foto", unique=true)
	private String foto_fun;
	

	@Column(name = "fun_residencial")
	private String residencial_fun;
	
	@NotNull(message="{fun.celular.NotEmpty}")
	@Size(min=8, max=20, message = "{fun.celular.Size}")
	@Column(name = "fun_celular")
	private String celular_fun;
	
	@NotNull(message="{fun.email.NotEmpty}")
	@Size(min=10, max=255, message = "{fun.email.Size}")
	@Column(name = "fun_email", unique=true)
	private String email_fun;
	
	@NotNull(message="{fun.senha.NotEmpty}")
	@Size(min=6, max=255, message = "{fun.senha.Size}")
	@Column(name = "fun_senha")
	private String senha_fun;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// MUITOS Ramais est�o em UM Setor	(N-1)
	@ManyToOne
	@JoinColumn(name = "cargo_id_cargo", insertable=true, updatable=true)
	private Cargo cargo;
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="funcionario")
	private Set<Relatorio> relatorios;
	
	// Outros M�todos
	public void criptografar_senha(String senha_fun) {
		String senha_fun_criptografada = new Crypt().criptografar(senha_fun);
		this.senha_fun = senha_fun_criptografada;
	}
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome_fun() {
		return nome_fun;
	}

	public void setNome_fun(String nome_fun) {
		this.nome_fun = nome_fun;
	}

	public String getCpf_fun() {
		return cpf_fun;
	}

	public void setCpf_fun(String cpf_fun) {
		this.cpf_fun = cpf_fun;
	}

	public Boolean getBloqueado_fun() {
		return bloqueado_fun;
	}

	public void setBloqueado_fun(Boolean bloqueado_fun) {
		this.bloqueado_fun = bloqueado_fun;
	}

	public String getFoto_fun() {
		return foto_fun;
	}

	public void setFoto_fun(String foto_fun) {
		this.foto_fun = foto_fun;
	}

	public String getResidencial_fun() {
		return residencial_fun;
	}

	public void setResidencial_fun(String residencial_fun) {
		this.residencial_fun = residencial_fun;
	}

	public String getCelular_fun() {
		return celular_fun;
	}

	public void setCelular_fun(String celular_fun) {
		this.celular_fun = celular_fun;
	}

	public String getEmail_fun() {
		return email_fun;
	}

	public void setEmail_fun(String email_fun) {
		this.email_fun = email_fun;
	}

	public String getSenha_fun() {
		return senha_fun;
	}

	public void setSenha_fun(String senha_fun) {
		this.senha_fun = senha_fun;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Set<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(Set<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
	
	
}
