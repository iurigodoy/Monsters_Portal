package br.com.monster.portal.model;

import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.monster.portal.security.Crypt;

@Entity
@Table(name = "cliente")
public class Cliente extends Historico {

	@Id
	@GeneratedValue
	private Long id_cliente;
	
	@NotNull(message="{cli.nome.NotEmpty}")
	@Size(min=3, max=200, message = "{cli.nome.Size}")
	@Column(name = "cli_nome")
	private String nome_cli;
	
	
	@Column(name = "cli_cpf")
	private String cpf_cli;

	
	@Column(name = "cli_cnpj")
	private String cnpj_cli;


	@Column(name = "cli_sexo")
	private String sexo_cli;

	
	@Column(name = "cli_ativo")
	private Boolean ativo_cli;

	@NotNull(message="{cli.senha.NotEmpty}")
	@Size(min=6, max=255, message = "{cli.senha.Size}")
	@Column(name = "cli_senha")
	private String senha_cli;


	@Column(name = "cli_news_letter")
	private Boolean news_letter_cli;

	
	@Column(name = "cli_cep")
	private String cep_cli;

	
	@Column(name = "cli_estado")
	private String estado_cli;

	
	@Column(name = "cli_cidade")
	private String cidade_cli;

	
	@Column(name = "cli_endereco")
	private String endereco_cli;

	
	@Column(name = "cli_numero")
	private String numero_cli;

	
	@Column(name = "cli_complemento")
	private String complemento_cli;

	
	@Column(name = "cli_residencial")
	private String residencial_cli;

	
	@Column(name = "cli_celular")
	private String celular_cli;

	@NotNull(message="{cli.email.NotEmpty}")
	@Size(min=10, max=255, message = "{cli.email.Size}")
	@Column(name = "cli_email", unique=true)
	private String email_cli;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	@OneToMany(mappedBy="cliente")
	private Set<Pedido> pedido;


	// Outros M�todos
	public static String criptografar_senha(String senha) {
		String senha_cli_criptografada = new Crypt().criptografar(senha);
		senha = senha_cli_criptografada;
		return senha;
	}
	
	public String getPrimeiroNome(){
		String[] primeiroNome = nome_cli.split (Pattern.quote (" "));
		return primeiroNome[0];
	}
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}

	public String getCpf_cli() {
		return cpf_cli;
	}

	public void setCpf_cli(String cpf_cli) {
		this.cpf_cli = cpf_cli;
	}

	public String getCnpj_cli() {
		return cnpj_cli;
	}

	public void setCnpj_cli(String cnpj_cli) {
		this.cnpj_cli = cnpj_cli;
	}

	public String getSexo_cli() {
		return sexo_cli;
	}

	public void setSexo_cli(String sexo_cli) {
		this.sexo_cli = sexo_cli;
	}

	public Boolean getAtivo_cli() {
		return ativo_cli;
	}

	public void setAtivo_cli(Boolean ativo_cli) {
		this.ativo_cli = ativo_cli;
	}

	public String getSenha_cli() {
		return senha_cli;
	}

	public void setSenha_cli(String senha_cli) {
		this.senha_cli = senha_cli;
	}

	public Boolean getNews_letter_cli() {
		return news_letter_cli;
	}

	public void setNews_letter_cli(Boolean news_letter_cli) {
		this.news_letter_cli = news_letter_cli;
	}

	public String getCep_cli() {
		return cep_cli;
	}

	public void setCep_cli(String cep_cli) {
		this.cep_cli = cep_cli;
	}

	public String getEstado_cli() {
		return estado_cli;
	}

	public void setEstado_cli(String estado_cli) {
		this.estado_cli = estado_cli;
	}

	public String getCidade_cli() {
		return cidade_cli;
	}

	public void setCidade_cli(String cidade_cli) {
		this.cidade_cli = cidade_cli;
	}

	public String getEndereco_cli() {
		return endereco_cli;
	}

	public void setEndereco_cli(String endereco_cli) {
		this.endereco_cli = endereco_cli;
	}

	public String getNumero_cli() {
		return numero_cli;
	}

	public void setNumero_cli(String numero_cli) {
		this.numero_cli = numero_cli;
	}

	public String getComplemento_cli() {
		return complemento_cli;
	}

	public void setComplemento_cli(String complemento_cli) {
		this.complemento_cli = complemento_cli;
	}

	public String getResidencial_cli() {
		return residencial_cli;
	}

	public void setResidencial_cli(String residencial_cli) {
		this.residencial_cli = residencial_cli;
	}

	public String getCelular_cli() {
		return celular_cli;
	}

	public void setCelular_cli(String celular_cli) {
		this.celular_cli = celular_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public Set<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}
	
}
