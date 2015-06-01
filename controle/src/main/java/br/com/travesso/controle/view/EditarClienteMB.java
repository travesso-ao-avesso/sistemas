package br.com.travesso.controle.view;

import javax.inject.Inject;

import br.com.travesso.controle.business.ClienteBC;
import br.com.travesso.controle.domain.Cliente;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_clientes.xhtml")
public class EditarClienteMB extends AbstractEditPageBean<Cliente, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteBC clienteBC;

	@Override
	@Transactional
	public String delete() {
		this.clienteBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.clienteBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.clienteBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected Cliente handleLoad(Integer id) {
		return this.clienteBC.load(id);
	}
}
