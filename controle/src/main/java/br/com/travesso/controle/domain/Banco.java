package br.com.travesso.controle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bancos")
public class Banco extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name="codigo", nullable = false)
    private Integer codigo;
	
	@Column(name = "nome", length = 160, nullable = false)
	private String nome;

	public Banco() {
		super();
	}

	public Banco(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Banco [" + super.toString() + ", codigo = " + this.codigo + ", nome = " + this.nome + "]";
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

