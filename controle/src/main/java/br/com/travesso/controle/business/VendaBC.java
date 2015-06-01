package br.com.travesso.controle.business;

import javax.inject.Inject;

import br.com.travesso.controle.domain.Venda;
import br.com.travesso.controle.persistence.VendaDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class VendaBC extends DelegateCrud<Venda, Integer, VendaDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaReceberBC contaReceberBC;
	
	public void registrarVenda(Venda venda){
		getDelegate().insert(venda);
		//contaReceberBC.inserirContasReceber(venda);
	}
	
}