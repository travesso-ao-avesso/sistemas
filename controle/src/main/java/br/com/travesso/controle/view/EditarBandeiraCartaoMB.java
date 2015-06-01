package br.com.travesso.controle.view;

import javax.inject.Inject;

import br.com.travesso.controle.business.BandeiraCartaoBC;
import br.com.travesso.controle.domain.BandeiraCartao;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_bandeiras_cartao.xhtml")
public class EditarBandeiraCartaoMB extends AbstractEditPageBean<BandeiraCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BandeiraCartaoBC bandeiraCartaoBC;

	@Override
	@Transactional
	public String delete() {
		this.bandeiraCartaoBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.bandeiraCartaoBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.bandeiraCartaoBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected BandeiraCartao handleLoad(Integer id) {
		return this.bandeiraCartaoBC.load(id);
	}
}
