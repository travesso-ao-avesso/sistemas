package br.com.travesso.controle.business;

import br.com.travesso.controle.domain.Cliente;
import br.com.travesso.controle.persistence.ClienteDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class ClienteBC extends DelegateCrud<Cliente, Integer, ClienteDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Cliente("Cris"));
			insert(new Cliente("Vivi"));
			insert(new Cliente("Mônica"));
		}
	}

}
