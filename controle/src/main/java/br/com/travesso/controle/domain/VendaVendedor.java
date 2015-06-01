package br.com.travesso.controle.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vendas_vendedores")
public class VendaVendedor extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_venda", nullable = false)
	private Venda venda;
	
	@ManyToOne
	@JoinColumn(name="id_vendedor", nullable = false)
	private Vendedor vendedor;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;
	
	public VendaVendedor() {
		super();
	}

	@Override
	public String toString() {
		return "VendaVendedor [" + super.toString() + ", id_venda = " + this.venda.getId() + ", id_vendedor = " + this.vendedor.getId() + "]";
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		result = prime * result
				+ ((vendedor == null) ? 0 : vendedor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		VendaVendedor other = (VendaVendedor) obj;
		if (venda == null) {
			if (other.venda != null) {
				return false;
			}
		} else if (!venda.equals(other.venda)) {
			return false;
		}
		if (vendedor == null) {
			if (other.vendedor != null) {
				return false;
			}
		} else if (!vendedor.equals(other.vendedor)) {
			return false;
		}
		return true;
	}

}

