package br.com.travesso.controle.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pagamentos_cheque")
public class PagamentoCheque extends Pagamento {

	@Transient
	private static final long serialVersionUID = 1L;
	
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name="id_banco", nullable = false)
	private Banco banco;

	public PagamentoCheque() {
		super();
	}

	@Override
	public String toString() {
		return "PagamentoCheque [" + super.toString() + ", número = " + this.numero + ", banco = " + this.banco.getNome() + "]";
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}

