package br.com.travesso.controle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "login" }),
		@UniqueConstraint(columnNames = { "cpf" }) })
public class Usuario extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "login", length = 16, nullable = false)
	private String login;

	@Column(name = "senha", length = 64, nullable = false)
	private String senha;

	@Transient
	private String confirmacaoSenha;

	@Column(name = "nome", length = 160, nullable = false)
	private String nome;

	@Column(name = "email", length = 255, nullable = false)
	private String email;

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [" + super.toString() + ", login = " + this.login + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

}

