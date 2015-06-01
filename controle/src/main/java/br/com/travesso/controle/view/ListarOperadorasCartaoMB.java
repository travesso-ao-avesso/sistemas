package br.com.travesso.controle.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.business.OperadoraCartaoBC;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("/editar_operadora_cartao.xhtml")
@PreviousView("/listar_operadoras_cartao.xhtml")
public class ListarOperadorasCartaoMB extends AbstractListPageBean<OperadoraCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OperadoraCartaoBC bc;

	@Override
	protected List<OperadoraCartao> handleResultList() {
		return this.bc.findAll();
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}
