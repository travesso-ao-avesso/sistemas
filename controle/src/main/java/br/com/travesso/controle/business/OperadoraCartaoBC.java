package br.com.travesso.controle.business;

import br.com.travesso.controle.domain.OperadoraCartao;
import br.com.travesso.controle.persistence.OperadoraCartaoDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class OperadoraCartaoBC extends DelegateCrud<OperadoraCartao, Integer, OperadoraCartaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new OperadoraCartao("Cielo"));
		}
	}

}
