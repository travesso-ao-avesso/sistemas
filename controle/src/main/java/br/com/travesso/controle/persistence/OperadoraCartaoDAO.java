package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.OperadoraCartao;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class OperadoraCartaoDAO extends JPACrud<OperadoraCartao, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
