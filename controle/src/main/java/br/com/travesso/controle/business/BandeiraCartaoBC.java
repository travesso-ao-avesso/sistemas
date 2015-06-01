package br.com.travesso.controle.business;

import br.com.travesso.controle.domain.BandeiraCartao;
import br.com.travesso.controle.persistence.BandeiraCartaoDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class BandeiraCartaoBC extends DelegateCrud<BandeiraCartao, Integer, BandeiraCartaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new BandeiraCartao("MasterCard"));
			insert(new BandeiraCartao("Visa"));
			insert(new BandeiraCartao("Elo"));
		}
	}

}
