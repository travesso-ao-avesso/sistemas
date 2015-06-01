package br.com.travesso.controle.view;

import java.util.List;

import javax.inject.Inject;

import br.com.travesso.controle.business.BandeiraCartaoBC;
import br.com.travesso.controle.business.OperadoraCartaoBC;
import br.com.travesso.controle.business.TaxaCartaoBC;
import br.com.travesso.controle.domain.BandeiraCartao;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.com.travesso.controle.domain.TaxaCartao;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_taxas_cartao.xhtml")
public class EditarTaxaCartaoMB extends AbstractEditPageBean<TaxaCartao, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TaxaCartaoBC taxaCartaoBC;
	
	@Inject
	private OperadoraCartaoBC operadoraCartaoBC;

	@Inject
	private BandeiraCartaoBC bandeiraCartaoBC;

	@Override
	@Transactional
	public String delete() {
		this.taxaCartaoBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.taxaCartaoBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.taxaCartaoBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected TaxaCartao handleLoad(Integer id) {
		return this.taxaCartaoBC.load(id);
	}

	public List<OperadoraCartao> getListaOperadorasCartao(){
		return operadoraCartaoBC.findAll();
	}
	
	public List<BandeiraCartao> getListaBandeirasCartao(){
		return bandeiraCartaoBC.findAll();
	}
}
