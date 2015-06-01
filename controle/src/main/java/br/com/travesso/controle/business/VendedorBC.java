package br.com.travesso.controle.business;

import br.com.travesso.controle.domain.Vendedor;
import br.com.travesso.controle.persistence.VendedorDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class VendedorBC extends DelegateCrud<Vendedor, Integer, VendedorDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Vendedor("Rose", "Roselange Nunes Gendiroba"));
			insert(new Vendedor("Dri", "Adriane Leles de Oliveira"));
		}
	}
	
}
