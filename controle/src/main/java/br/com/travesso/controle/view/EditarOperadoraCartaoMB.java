package br.com.travesso.controle.view;

import javax.inject.Inject;

import br.com.travesso.controle.business.OperadoraCartaoBC;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_operadoras_cartao.xhtml")
public class EditarOperadoraCartaoMB extends AbstractEditPageBean<OperadoraCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OperadoraCartaoBC operadoraCartaoBC;

	@Override
	@Transactional
	public String delete() {
		this.operadoraCartaoBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.operadoraCartaoBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.operadoraCartaoBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected OperadoraCartao handleLoad(Integer id) {
		return this.operadoraCartaoBC.load(id);
	}
}
