package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.Venda;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class VendaDAO extends JPACrud<Venda, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
