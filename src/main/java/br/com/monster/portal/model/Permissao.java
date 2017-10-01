package br.com.monster.portal.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
	
	@Id
	@GeneratedValue
	private Long id_permissoes;
	
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
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cargo_id_cargo", insertable=true, updatable=true)
	private Cargo cargo;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_permissao() {
		return id_permissoes;
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



	public Long getId_permissoes() {
		return id_permissoes;
	}

	public void setId_permissoes(Long id_permissoes) {
		this.id_permissoes = id_permissoes;
	}

	public void setLerBanner(boolean lerBanner) {
		this.lerBanner = lerBanner;
	}

	public void setCriarBanner(boolean criarBanner) {
		this.criarBanner = criarBanner;
	}

	public void setAtualizarBanner(boolean atualizarBanner) {
		this.atualizarBanner = atualizarBanner;
	}

	public void setExcluirBanner(boolean excluirBanner) {
		this.excluirBanner = excluirBanner;
	}

	public void setRestaurarBanner(boolean restaurarBanner) {
		this.restaurarBanner = restaurarBanner;
	}

	public void setLerCampanha(boolean lerCampanha) {
		this.lerCampanha = lerCampanha;
	}

	public void setCriarCampanha(boolean criarCampanha) {
		this.criarCampanha = criarCampanha;
	}

	public void setAtualizarCampanha(boolean atualizarCampanha) {
		this.atualizarCampanha = atualizarCampanha;
	}

	public void setExcluirCampanha(boolean excluirCampanha) {
		this.excluirCampanha = excluirCampanha;
	}

	public void setRestaurarCampanha(boolean restaurarCampanha) {
		this.restaurarCampanha = restaurarCampanha;
	}

	public void setLerCargo(boolean lerCargo) {
		this.lerCargo = lerCargo;
	}

	public void setCriarCargo(boolean criarCargo) {
		this.criarCargo = criarCargo;
	}

	public void setAtualizarCargo(boolean atualizarCargo) {
		this.atualizarCargo = atualizarCargo;
	}

	public void setExcluirCargo(boolean excluirCargo) {
		this.excluirCargo = excluirCargo;
	}

	public void setRestaurarCargo(boolean restaurarCargo) {
		this.restaurarCargo = restaurarCargo;
	}

	public void setLerCategoria(boolean lerCategoria) {
		this.lerCategoria = lerCategoria;
	}

	public void setCriarCategoria(boolean criarCategoria) {
		this.criarCategoria = criarCategoria;
	}

	public void setAtualizarCategoria(boolean atualizarCategoria) {
		this.atualizarCategoria = atualizarCategoria;
	}

	public void setExcluirCategoria(boolean excluirCategoria) {
		this.excluirCategoria = excluirCategoria;
	}

	public void setRestaurarCategoria(boolean restaurarCategoria) {
		this.restaurarCategoria = restaurarCategoria;
	}

	public void setLerCliente(boolean lerCliente) {
		this.lerCliente = lerCliente;
	}

	public void setCriarCliente(boolean criarCliente) {
		this.criarCliente = criarCliente;
	}

	public void setAtualizarCliente(boolean atualizarCliente) {
		this.atualizarCliente = atualizarCliente;
	}

	public void setExcluirCliente(boolean excluirCliente) {
		this.excluirCliente = excluirCliente;
	}

	public void setRestaurarCliente(boolean restaurarCliente) {
		this.restaurarCliente = restaurarCliente;
	}

	public void setLerFornecedor(boolean lerFornecedor) {
		this.lerFornecedor = lerFornecedor;
	}

	public void setCriarFornecedor(boolean criarFornecedor) {
		this.criarFornecedor = criarFornecedor;
	}

	public void setAtualizarFornecedor(boolean atualizarFornecedor) {
		this.atualizarFornecedor = atualizarFornecedor;
	}

	public void setExcluirFornecedor(boolean excluirFornecedor) {
		this.excluirFornecedor = excluirFornecedor;
	}

	public void setRestaurarFornecedor(boolean restaurarFornecedor) {
		this.restaurarFornecedor = restaurarFornecedor;
	}

	public void setLerFuncionario(boolean lerFuncionario) {
		this.lerFuncionario = lerFuncionario;
	}

	public void setCriarFuncionario(boolean criarFuncionario) {
		this.criarFuncionario = criarFuncionario;
	}

	public void setAtualizarFuncionario(boolean atualizarFuncionario) {
		this.atualizarFuncionario = atualizarFuncionario;
	}

	public void setExcluirFuncionario(boolean excluirFuncionario) {
		this.excluirFuncionario = excluirFuncionario;
	}

	public void setRestaurarFuncionario(boolean restaurarFuncionario) {
		this.restaurarFuncionario = restaurarFuncionario;
	}

	public void setLerPedido(boolean lerPedido) {
		this.lerPedido = lerPedido;
	}

	public void setCriarPedido(boolean criarPedido) {
		this.criarPedido = criarPedido;
	}

	public void setAtualizarPedido(boolean atualizarPedido) {
		this.atualizarPedido = atualizarPedido;
	}

	public void setExcluirPedido(boolean excluirPedido) {
		this.excluirPedido = excluirPedido;
	}

	public void setRestaurarPedido(boolean restaurarPedido) {
		this.restaurarPedido = restaurarPedido;
	}

	public void setLerProduto(boolean lerProduto) {
		this.lerProduto = lerProduto;
	}

	public void setCriarProduto(boolean criarProduto) {
		this.criarProduto = criarProduto;
	}

	public void setAtualizarProduto(boolean atualizarProduto) {
		this.atualizarProduto = atualizarProduto;
	}

	public void setExcluirProduto(boolean excluirProduto) {
		this.excluirProduto = excluirProduto;
	}

	public void setRestaurarProduto(boolean restaurarProduto) {
		this.restaurarProduto = restaurarProduto;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
}
