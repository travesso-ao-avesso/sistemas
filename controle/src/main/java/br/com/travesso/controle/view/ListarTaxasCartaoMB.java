package br.com.travesso.controle.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.business.TaxaCartaoBC;
import br.com.travesso.controle.domain.TaxaCartao;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("/editar_taxa_cartao.xhtml")
@PreviousView("/listar_taxas_cartao.xhtml")
public class ListarTaxasCartaoMB extends AbstractListPageBean<TaxaCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TaxaCartaoBC bc;

	@Override
	protected List<TaxaCartao> handleResultList() {
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
