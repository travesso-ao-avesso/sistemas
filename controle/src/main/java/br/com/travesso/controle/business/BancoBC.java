package br.com.travesso.controle.business;

import br.com.travesso.controle.domain.Banco;
import br.com.travesso.controle.persistence.BancoDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class BancoBC extends DelegateCrud<Banco, Integer, BancoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Banco(1, "Banco do Brasil"));
			insert(new Banco(104, "Caixa Econômica Federal"));
		}
	}

}
