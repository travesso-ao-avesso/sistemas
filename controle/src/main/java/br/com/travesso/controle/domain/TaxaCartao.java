package br.com.travesso.controle.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.travesso.controle.domain.enumeration.PrazoPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.TipoCartaoEnum;

@Entity
@Table(name = "taxas_cartao")
public class TaxaCartao extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="id_operadora", nullable = false)
	private OperadoraCartao operadora;

	@ManyToOne
	@JoinColumn(name="id_bandeira", nullable = false)
	private BandeiraCartao bandeira;

	@Column(name = "tipo_cartao")
	@Enumerated(EnumType.STRING)
	private TipoCartaoEnum tipoCartao;

	@Column(name = "prazo_pagamento")
	@Enumerated(EnumType.STRING)
	private PrazoPagamentoEnum prazoPagamento;

	@Column(name="taxa", nullable = false)
	private BigDecimal taxa;
	
	@Column(name="parcelas", nullable = false)
	private int parcelas;
	
	public TaxaCartao() {
		super();
	}

	public TaxaCartao(OperadoraCartao operadora, BandeiraCartao bandeira,
			TipoCartaoEnum tipoCartao, PrazoPagamentoEnum prazoPagamento,
			BigDecimal taxa, int parcelas) {
		super();
		this.operadora = operadora;
		this.bandeira = bandeira;
		this.tipoCartao = tipoCartao;
		this.prazoPagamento = prazoPagamento;
		this.taxa = taxa;
		this.parcelas = parcelas;
	}
	
	@Override
	public String toString() {
		return "TaxaCartao [" + super.toString() + ", operadora = " + this.operadora + ", bandeira = " + this.bandeira +", tipoCartao = " + this.tipoCartao.getDescricao() +", prazoPagamento = " + this.prazoPagamento.getDescricao() +", taxa = " + this.taxa +"]";
	}

	public OperadoraCartao getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraCartao operadora) {
		this.operadora = operadora;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public TipoCartaoEnum getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartaoEnum tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public PrazoPagamentoEnum getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(PrazoPagamentoEnum prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
}

