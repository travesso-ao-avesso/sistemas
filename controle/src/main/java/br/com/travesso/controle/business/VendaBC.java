package br.com.travesso.controle.business;

import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.domain.Venda;
import br.com.travesso.controle.domain.VendaVendedor;
import br.com.travesso.controle.domain.Vendedor;
import br.com.travesso.controle.exception.NegocioException;
import br.com.travesso.controle.persistence.VendaDAO;
import br.com.travesso.controle.util.ErrorMessage;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class VendaBC extends DelegateCrud<Venda, Integer, VendaDAO> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContaReceberBC contaReceberBC;

	public void registrarVenda(Venda venda) {
		getDelegate().insert(venda);
	}

	public void validarInclusaoVendaVendedor(Vendedor vendedor,
			List<VendaVendedor> vendasVendedores) throws NegocioException {
		if (ehVendedorJaIncluido(vendedor, vendasVendedores)) {
			throw new NegocioException(ErrorMessage.ER001);
		}
	}

	private boolean ehVendedorJaIncluido(Vendedor vendedor,
			List<VendaVendedor> vvIncluido) {
		for (VendaVendedor vv : vvIncluido) {
			if (vendedor != null && vendedor.equals(vv.getVendedor())) {
				return true;
			}
		}
		return false;
	}

}