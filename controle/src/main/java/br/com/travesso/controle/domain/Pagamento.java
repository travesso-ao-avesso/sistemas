package br.com.travesso.controle.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.travesso.controle.domain.enumeration.FormaPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.PrazoPagamentoEnum;

@Entity
@Table(name="pagamentos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn( name = "forma_pagamento", discriminatorType = DiscriminatorType.STRING)
public abstract class Pagamento extends BaseEntity {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name = "parcelas")
	private int parcelas;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column(name = "forma_pagamento", length = 10)
	@Enumerated(EnumType.STRING)
	private FormaPagamentoEnum formaPagamento;
	
	@Column(name = "prazo_pagamento", length = 10)
	@Enumerated(EnumType.STRING)
	private PrazoPagamentoEnum prazoPagamento;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_venda")
    private Venda venda;
	
    @OneToMany(mappedBy = "pagamento", cascade = {CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ContaReceber> listaContasReceber = new ArrayList<ContaReceber>();
	
	public Pagamento() {
		super();
	}

	@Override
	public String toString() {
		return "Pagamento [" + super.toString() + ", valor =" + this.valor+ ", data = " + this.data + "]";
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<ContaReceber> getListaContasReceber() {
		return listaContasReceber;
	}

	public void setListaContasReceber(List<ContaReceber> listaContasReceber) {
		this.listaContasReceber = listaContasReceber;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public FormaPagamentoEnum getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public PrazoPagamentoEnum getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(PrazoPagamentoEnum prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

}

