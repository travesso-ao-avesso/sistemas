package br.com.travesso.controle.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.business.BancoBC;
import br.com.travesso.controle.domain.Banco;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("/editar_banco.xhtml")
@PreviousView("/listar_bancos.xhtml")
public class ListarBancosMB extends AbstractListPageBean<Banco, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BancoBC bc;

	@Override
	protected List<Banco> handleResultList() {
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
