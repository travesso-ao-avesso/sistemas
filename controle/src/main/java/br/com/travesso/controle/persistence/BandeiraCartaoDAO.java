package br.com.travesso.controle.persistence;

import br.com.travesso.controle.domain.BandeiraCartao;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class BandeiraCartaoDAO extends JPACrud<BandeiraCartao, Integer> {
	
	private static final long serialVersionUID = 1L;
	
}
