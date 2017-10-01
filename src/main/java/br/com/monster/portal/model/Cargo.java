package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cargo")
public class Cargo extends Historico {
	
	@Id
	@GeneratedValue
	private Long id_cargo;
	
	@NotNull(message="{car.nome.NotEmpty}")
	@Size(min=2, max=100, message = "{car.nome.Size}")
	@Column(name = "car_nome")
	private String nome_car;
	
	
	@Column(name = "car_padrao")
	private Boolean padrao_car;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	// UM Ramal tem MUITOS Funcion�rios	(1-N)
	@OneToMany(mappedBy="cargo")
	private Set<Funcionario> funcionario;
	
	@OneToOne(mappedBy="cargo", fetch=FetchType.EAGER)
	private Permissao permissao;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	
	public Long getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Long id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getNome_car() {
		return nome_car;
	}

	public void setNome_car(String nome_car) {
		this.nome_car = nome_car;
	}

	public Boolean getPadrao_car() {
		return padrao_car;
	}

	public void setPadrao_car(Boolean padrao_car) {
		this.padrao_car = padrao_car;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Set<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermisao(Permissao permissao) {
		this.permissao = permissao;
	}
	
	
}
