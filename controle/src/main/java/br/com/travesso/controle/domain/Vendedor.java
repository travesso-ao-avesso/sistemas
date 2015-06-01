package br.com.travesso.controle.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vendedores")
public class Vendedor extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "apelido", length = 16, nullable = false, unique = true)
	private String apelido;

	@Column(name = "nome", length = 160, nullable = false)
	private String nome;
	
    @OneToMany(mappedBy = "vendedor", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<VendaVendedor> vendasVendedores = new HashSet<VendaVendedor>();

	public Vendedor() {
		super();
	}

	public Vendedor(String apelido, String nome) {
		super();
		this.apelido = apelido;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Vendedor [" + super.toString() + ", apelido = " + this.apelido + "]";
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<VendaVendedor> getVendasVendedores() {
		return vendasVendedores;
	}

	public void setVendasVendedores(Set<VendaVendedor> vendasVendedores) {
		this.vendasVendedores = vendasVendedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((vendasVendedores == null) ? 0 : vendasVendedores.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		Vendedor other = (Vendedor) obj;
		if (apelido == null) {
			if (other.apelido != null) {
				return false;
			}
		} else if (!apelido.equals(other.apelido)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (vendasVendedores == null) {
			if (other.vendasVendedores != null) {
				return false;
			}
		} else if (!vendasVendedores.equals(other.vendasVendedores)) {
			return false;
		}
		return true;
	}


}

