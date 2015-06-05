package br.com.travesso.controle.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "vendas")
public class Venda extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="sequencial")
	private Integer sequencial;
	
	@Column(name = "documento")
	private Integer documento;
		
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "observacao", length = 255)
	private String observacao;
	
	@Column(name = "troca")
	private boolean troca;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Calendar data;

    @OneToMany(mappedBy = "venda", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<Pagamento>();

	@ManyToOne
	@JoinColumn(name="id_cliente", nullable = false)
	private Cliente cliente;
	
    @OneToMany(mappedBy = "venda", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<VendaVendedor> vendasVendedores = new ArrayList<VendaVendedor>();
    
	public Venda() {
		super();
	}

	@Override
	public String toString() {
		return "Venda [" + super.toString() + ", sequencial = " + this.sequencial + ", documento = " +  this.documento + "]";
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isTroca() {
		return troca;
	}

	public void setTroca(boolean troca) {
		this.troca = troca;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<VendaVendedor> getVendasVendedores() {
		return vendasVendedores;
	}

	public void setVendasVendedores(List<VendaVendedor> vendasVendedores) {
		this.vendasVendedores = vendasVendedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((pagamentos == null) ? 0 : pagamentos.hashCode());
		result = prime * result
				+ ((sequencial == null) ? 0 : sequencial.hashCode());
		result = prime * result + (troca ? 1231 : 1237);
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (documento == null) {
			if (other.documento != null) {
				return false;
			}
		} else if (!documento.equals(other.documento)) {
			return false;
		}
		if (observacao == null) {
			if (other.observacao != null) {
				return false;
			}
		} else if (!observacao.equals(other.observacao)) {
			return false;
		}
		if (pagamentos == null) {
			if (other.pagamentos != null) {
				return false;
			}
		} else if (!pagamentos.equals(other.pagamentos)) {
			return false;
		}
		if (sequencial == null) {
			if (other.sequencial != null) {
				return false;
			}
		} else if (!sequencial.equals(other.sequencial)) {
			return false;
		}
		if (troca != other.troca) {
			return false;
		}
		if (valor == null) {
			if (other.valor != null) {
				return false;
			}
		} else if (!valor.equals(other.valor)) {
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

