package br.com.travesso.controle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bandeiras_cartao")
public class BandeiraCartao extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "nome", length = 16, nullable = false)
	private String nome;

	public BandeiraCartao() {
		super();
	}

	public BandeiraCartao(String nome) {
		super();
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Bandeira [" + super.toString() + ", nome = " + this.nome + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BandeiraCartao other = (BandeiraCartao) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		return true;
	}
}

