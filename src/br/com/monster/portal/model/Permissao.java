package br.com.monster.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
	
	@Id
	@GeneratedValue
	private Long id_permissao;
	
	private boolean lerBanner;
	private boolean criarBanner;
	private boolean atualizarBanner;
	private boolean excluirBanner;
	private boolean restaurarBanner;
	
	private boolean lerCampanha;
	private boolean criarCampanha;
	private boolean atualizarCampanha;
	private boolean excluirCampanha;
	private boolean restaurarCampanha;
	
	private boolean lerCargo;
	private boolean criarCargo;
	private boolean atualizarCargo;
	private boolean excluirCargo;
	private boolean restaurarCargo;
	
	private boolean lerCategoria;
	private boolean criarCategoria;
	private boolean atualizarCategoria;
	private boolean excluirCategoria;
	private boolean restaurarCategoria;
	
	private boolean lerCliente;
	private boolean criarCliente;
	private boolean atualizarCliente;
	private boolean excluirCliente;
	private boolean restaurarCliente;
	
	private boolean lerFornecedor;
	private boolean criarFornecedor;
	private boolean atualizarFornecedor;
	private boolean excluirFornecedor;
	private boolean restaurarFornecedor;
	
	private boolean lerFuncionario;
	private boolean criarFuncionario;
	private boolean atualizarFuncionario;
	private boolean excluirFuncionario;
	private boolean restaurarFuncionario;
	
	private boolean lerPedido;
	private boolean criarPedido;
	private boolean atualizarPedido;
	private boolean excluirPedido;
	private boolean restaurarPedido;
	
	private boolean lerProduto;
	private boolean criarProduto;
	private boolean atualizarProduto;
	private boolean excluirProduto;
	private boolean restaurarProduto;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */

	// MUITAS Permissões para UM Cargo	(N-1)
	@ManyToOne
	@JoinColumn(name = "cargo_id_cargo", insertable=true, updatable=true)
	private Cargo cargo;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_permissao() {
		return id_permissao;
	}

	public boolean isLerBanner() {
		return lerBanner;
	}

	public boolean isCriarBanner() {
		return criarBanner;
	}

	public boolean isAtualizarBanner() {
		return atualizarBanner;
	}

	public boolean isExcluirBanner() {
		return excluirBanner;
	}

	public boolean isRestaurarBanner() {
		return restaurarBanner;
	}



	public boolean isLerCampanha() {
		return lerCampanha;
	}

	public boolean isCriarCampanha() {
		return criarCampanha;
	}

	public boolean isAtualizarCampanha() {
		return atualizarCampanha;
	}

	public boolean isExcluirCampanha() {
		return excluirCampanha;
	}

	public boolean isRestaurarCampanha() {
		return restaurarCampanha;
	}



	public boolean isLerCargo() {
		return lerCargo;
	}

	public boolean isCriarCargo() {
		return criarCargo;
	}

	public boolean isAtualizarCargo() {
		return atualizarCargo;
	}

	public boolean isExcluirCargo() {
		return excluirCargo;
	}

	public boolean isRestaurarCargo() {
		return restaurarCargo;
	}



	public boolean isLerCategoria() {
		return lerCategoria;
	}

	public boolean isCriarCategoria() {
		return criarCategoria;
	}

	public boolean isAtualizarCategoria() {
		return atualizarCategoria;
	}

	public boolean isExcluirCategoria() {
		return excluirCategoria;
	}

	public boolean isRestaurarCategoria() {
		return restaurarCategoria;
	}



	public boolean isLerCliente() {
		return lerCliente;
	}

	public boolean isCriarCliente() {
		return criarCliente;
	}

	public boolean isAtualizarCliente() {
		return atualizarCliente;
	}

	public boolean isExcluirCliente() {
		return excluirCliente;
	}

	public boolean isRestaurarCliente() {
		return restaurarCliente;
	}



	public boolean isLerFornecedor() {
		return lerFornecedor;
	}

	public boolean isCriarFornecedor() {
		return criarFornecedor;
	}

	public boolean isAtualizarFornecedor() {
		return atualizarFornecedor;
	}

	public boolean isExcluirFornecedor() {
		return excluirFornecedor;
	}

	public boolean isRestaurarFornecedor() {
		return restaurarFornecedor;
	}



	public boolean isLerFuncionario() {
		return lerFuncionario;
	}

	public boolean isCriarFuncionario() {
		return criarFuncionario;
	}

	public boolean isAtualizarFuncionario() {
		return atualizarFuncionario;
	}

	public boolean isExcluirFuncionario() {
		return excluirFuncionario;
	}

	public boolean isRestaurarFuncionario() {
		return restaurarFuncionario;
	}



	public boolean isLerPedido() {
		return lerPedido;
	}

	public boolean isCriarPedido() {
		return criarPedido;
	}

	public boolean isAtualizarPedido() {
		return atualizarPedido;
	}

	public boolean isExcluirPedido() {
		return excluirPedido;
	}

	public boolean isRestaurarPedido() {
		return restaurarPedido;
	}



	public boolean isLerProduto() {
		return lerProduto;
	}

	public boolean isCriarProduto() {
		return criarProduto;
	}

	public boolean isAtualizarProduto() {
		return atualizarProduto;
	}

	public boolean isExcluirProduto() {
		return excluirProduto;
	}

	public boolean isRestaurarProduto() {
		return restaurarProduto;
	}



	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
