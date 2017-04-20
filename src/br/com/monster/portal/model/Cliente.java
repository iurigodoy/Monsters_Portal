package br.com.monster.portal.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.monster.portal.security.Crypt;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id_cliente;
	
	@NotNull(message="{cli.nome.NotEmpty}")
	@Size(min=3, max=200, message = "{cli.nome.Size}")
	@Column(name = "cli_nome")			//Nome real dentro do banco
	private String nome_cli;			//Nome do campo no sistema
	
	
	@Column(name = "cli_cpf")			//Nome real dentro do banco
	private String cpf_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_cnpj")			//Nome real dentro do banco
	private String cnpj_cli;			//Nome do campo no sistema


	@Column(name = "cli_sexo")			//Nome real dentro do banco
	private String sexo_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_ativo")			//Nome real dentro do banco
	private Boolean ativo_cli;			//Nome do campo no sistema

	@NotNull(message="{cli.senha.NotEmpty}")
	@Size(min=6, max=255, message = "{cli.senha.Size}")
	@Column(name = "cli_senha")			//Nome real dentro do banco
	private String senha_cli;			//Nome do campo no sistema


	@Column(name = "cli_news_letter")			//Nome real dentro do banco
	private Boolean news_letter_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_cep")			//Nome real dentro do banco
	private String cep_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_estado")			//Nome real dentro do banco
	private String estado_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_cidade")			//Nome real dentro do banco
	private String cidade_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_endereco")			//Nome real dentro do banco
	private String endereco_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_numero")			//Nome real dentro do banco
	private String numero_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_complemento")			//Nome real dentro do banco
	private String complemento_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_residencial")			//Nome real dentro do banco
	private String residencial_cli;			//Nome do campo no sistema

	
	@Column(name = "cli_celular")			//Nome real dentro do banco
	private String celular_cli;			//Nome do campo no sistema

	@NotNull(message="{cli.email.NotEmpty}")
	@Size(min=10, max=255, message = "{cli.email.Size}")
	@Column(name = "cli_email")			//Nome real dentro do banco
	private String email_cli;			//Nome do campo no sistema
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updated_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_at")
	private Date deleted_at;
	
	@Column(name = "deleted")
	private Boolean deleted;

	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private Set<Acesso> acesso;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private Set<Avaliacao> avaliacao;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private Set<Pedido> pedido;
	
	public String form;

	
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Set<Acesso> getAcesso() {
		return acesso;
	}

	public void setAcesso(Set<Acesso> acesso) {
		this.acesso = acesso;
	}

	public Set<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Set<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Set<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(Set<Pedido> pedido) {
		this.pedido = pedido;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}


	public void criptografar_senha(String senha_cli) {
		String senha_cli_criptografada = new Crypt().criptografar(senha_cli);
		this.senha_cli = senha_cli_criptografada;
	}
	
}
