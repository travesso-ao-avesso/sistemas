package br.com.travesso.controle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.travesso.controle.domain.enumeration.TipoCartaoEnum;

@Entity
@Table(name = "pagamentos_cartao")
public class PagamentoCartao extends Pagamento {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name = "tipo_cartao", length = 10)
	@Enumerated(EnumType.STRING)
	private TipoCartaoEnum tipoCartao;
	
	@ManyToOne
	@JoinColumn(name="id_operadora", nullable = false)
	private OperadoraCartao operadora;

	@ManyToOne
	@JoinColumn(name="id_bandeira", nullable = false)
	private BandeiraCartao bandeira;
	
	public PagamentoCartao() {
		super();
	}
	
	@Override
	public String toString() {
		return "PagamentoCartao [" + super.toString() + ", tipoCartao = " + this.tipoCartao.getDescricao() + "]";
	}

	public TipoCartaoEnum getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartaoEnum tipoCartao) {
		this.tipoCartao = tipoCartao;
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

}

