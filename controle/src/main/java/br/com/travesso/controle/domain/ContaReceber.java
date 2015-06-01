package br.com.travesso.controle.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "contas_a_receber")
public class ContaReceber extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_pagamento")
    private Pagamento pagamento;
	
	@Column
	private boolean liquidada;
	
	public ContaReceber() {
		super();
	}

	@Override
	public String toString() {
		return "ContaReceber [" + super.toString() + ", pagamento =" + this.pagamento.toString() + ", valor = " + this.valor + ", data = " + this.data +  ", liquidada = " + this.liquidada + "]";
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isLiquidada() {
		return liquidada;
	}

	public void setLiquidada(boolean liquidada) {
		this.liquidada = liquidada;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
}

