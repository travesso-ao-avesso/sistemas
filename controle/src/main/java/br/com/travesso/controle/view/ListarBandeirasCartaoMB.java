package br.com.travesso.controle.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.business.BandeiraCartaoBC;
import br.com.travesso.controle.domain.BandeiraCartao;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("/editar_bandeira_cartao.xhtml")
@PreviousView("/listar_bandeiras_cartao.xhtml")
public class ListarBandeirasCartaoMB extends AbstractListPageBean<BandeiraCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BandeiraCartaoBC bc;

	@Override
	protected List<BandeiraCartao> handleResultList() {
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
