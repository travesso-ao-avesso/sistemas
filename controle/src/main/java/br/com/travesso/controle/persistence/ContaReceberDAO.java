package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.ContaReceber;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ContaReceberDAO extends JPACrud<ContaReceber, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
