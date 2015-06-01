package br.com.travesso.controle.business;

import java.math.BigDecimal;

import javax.inject.Inject;

import br.com.travesso.controle.domain.BandeiraCartao;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.com.travesso.controle.domain.TaxaCartao;
import br.com.travesso.controle.domain.enumeration.PrazoPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.TipoCartaoEnum;
import br.com.travesso.controle.persistence.TaxaCartaoDAO;
import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@BusinessController
public class TaxaCartaoBC extends DelegateCrud<TaxaCartao, Integer, TaxaCartaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private OperadoraCartaoBC operadoraCartaoBC;
	
	@Inject
	private BandeiraCartaoBC bandeiraCartaoBC;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {			
			insert(new TaxaCartao(operadoraCartaoBC.load(1), bandeiraCartaoBC.load(1), TipoCartaoEnum.DEBITO, PrazoPagamentoEnum.A_VISTA, new BigDecimal("0.0245"), 1));
			insert(new TaxaCartao(operadoraCartaoBC.load(1), bandeiraCartaoBC.load(1), TipoCartaoEnum.CREDITO, PrazoPagamentoEnum.A_VISTA, new BigDecimal("0.036"), 1));		
		}
	}
	
	public BigDecimal obterTaxaCartao(OperadoraCartao operadora, BandeiraCartao bandeira, TipoCartaoEnum tipo, PrazoPagamentoEnum prazo, int parcelas){
		TaxaCartao taxaCartao = getDelegate().obterTaxaCartao(operadora, bandeira, tipo, prazo, parcelas);
		return taxaCartao.getTaxa();
	}
}
