package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.Banco;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class BancoDAO extends JPACrud<Banco, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
