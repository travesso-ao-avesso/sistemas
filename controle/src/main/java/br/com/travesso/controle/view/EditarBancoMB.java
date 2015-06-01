package br.com.travesso.controle.view;

import javax.inject.Inject;

import br.com.travesso.controle.business.BancoBC;
import br.com.travesso.controle.domain.Banco;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_bancos.xhtml")
public class EditarBancoMB extends AbstractEditPageBean<Banco, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BancoBC bancoBC;

	@Override
	@Transactional
	public String delete() {
		this.bancoBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.bancoBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.bancoBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected Banco handleLoad(Integer id) {
		return this.bancoBC.load(id);
	}
}
