package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.Vendedor;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class VendedorDAO extends JPACrud<Vendedor, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
