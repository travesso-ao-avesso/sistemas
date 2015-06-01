package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.Cliente;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ClienteDAO extends JPACrud<Cliente, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
