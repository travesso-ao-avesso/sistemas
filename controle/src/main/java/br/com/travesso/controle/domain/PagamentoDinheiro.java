package br.com.travesso.controle.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pagamentos_dinheiro")
public class PagamentoDinheiro extends Pagamento {

	@Transient
	private static final long serialVersionUID = 1L;

	public PagamentoDinheiro() {
		super();
	}

	@Override
	public String toString() {
		return "PagamentoDinheiro [" + super.toString() + "]";
	}

}

