package br.com.travesso.controle.business;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import br.com.travesso.controle.domain.ContaReceber;
import br.com.travesso.controle.domain.Venda;
import br.com.travesso.controle.persistence.ContaReceberDAO;
import br.com.travesso.controle.util.DateUtil;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ContaReceberBC extends DelegateCrud<ContaReceber, Integer, ContaReceberDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaxaCartaoBC taxaCartaoBC;
	
	@Inject
	private DateUtil dateUtil;
		
//	public void inserirContasReceber(Venda venda){
//		if(venda.getFormaPagamento().equals(FormaPagamento.DINHEIRO)){
//			inserirContasReceberDinheiro(venda);
//		} else if(venda.getFormaPagamento().equals(FormaPagamento.CARTAO)){
//			inserirContasReceberCartao(venda);
//		} else if(venda.getFormaPagamento().equals(FormaPagamento.CHEQUE)){
//			inserirContasReceberCheque(venda);
//		} else if(venda.getFormaPagamento().equals(FormaPagamento.CREDIARIO)){
//			inserirContasReceberCrediario(venda);
//		} 
//
//	}

//	private void inserirContasReceberCartao(Venda venda) {
//		if(venda.getTipoCartao().equals(TipoCartao.DEBITO)){
//			inserirContasReceberCartaoDebito(venda);
//		} else if(venda.getTipoCartao().equals(TipoCartao.CREDITO)){
//			inserirContasReceberCartaoCredito(venda);
//		}
//	}

//	private void inserirContasReceberCartaoCredito(Venda venda) {
//		BigDecimal taxaCartaoCredito = obterTaxaCartao(venda);
//		BigDecimal valorDesconto = venda.getValor().multiply(taxaCartaoCredito);
//		inserirContasReceberParceladas(venda, valorDesconto);
//	}
	
//	private void inserirContasReceberCartaoDebito(Venda venda) {
//		BigDecimal taxaCartaoDebito = obterTaxaCartao(venda);
//		BigDecimal desconto = venda.getValor().multiply(taxaCartaoDebito);
//		BigDecimal valorReceber = venda.getValor().subtract(desconto);
//		Calendar dataRecebimento = new GregorianCalendar();
//		dateUtil.adicionaDias(dataRecebimento, Constantes.TAMANHOS.PRAZO_DEBITO);
//		dateUtil.configuraDiaUtil(dataRecebimento);
//		inserirContaReceber(venda, valorReceber, dataRecebimento.getTime());
//	}

	private void inserirContaReceber(Venda venda, BigDecimal valorReceber, Date dataRecebimento) {
		ContaReceber contaReceber = new ContaReceber();
   		contaReceber.setValor(valorReceber);
    	contaReceber.setData(dataRecebimento);
    	getDelegate().insert(contaReceber);
	}
	
//	private void inserirContasReceberDinheiro(Venda venda) {
//		inserirContaReceber(venda, venda.getValor(), venda.getData());
//	}

//	private void inserirContasReceberCheque(Venda venda) {
//		if(venda.getFormaPagamento().equals(PrazoPagamento.A_VISTA)){
//			inserirContaReceber(venda, null, venda.getData());
//		} else {
//			inserirContasReceberParceladas(venda, null);
//		}	
//	}

//	private void inserirContasReceberCrediario(Venda venda) {
//		inserirContasReceberParceladas(venda, null);
//	}
//	
//	private BigDecimal obterTaxaCartao(Venda venda){
//		return taxaCartaoBC.obterTaxaCartao(venda.getOperadora(), venda.getBandeira(), venda.getTipoCartao(), venda.getPrazoPagamento());		
//	}

//    private void inserirContasReceberParceladas(Venda venda, BigDecimal valorDesconto){
//    	int parcelas = venda.getParcelas();
//		int prazo = Constantes.TAMANHOS.PRAZO_CREDITO;
//		for(int i = 0; i < parcelas; i++){
//			Calendar dataRecebimento = new GregorianCalendar();
//			dateUtil.adicionaDias(dataRecebimento, prazo);
//			dateUtil.configuraDiaUtil(dataRecebimento);
//			BigDecimal valorParcelaReceber = BigDecimal.ZERO;
//			if(valorDesconto == null){
//				valorParcelaReceber = venda.getValor().divide(new BigDecimal(parcelas));
//			} else {
//				BigDecimal valorReceber = venda.getValor().subtract(valorDesconto);
//				valorParcelaReceber = valorReceber.divide(new BigDecimal(parcelas), 2, RoundingMode.HALF_DOWN).setScale(2);
//			}
//			inserirContaReceber(venda, valorParcelaReceber, dataRecebimento.getTime());
//			prazo+=Constantes.TAMANHOS.PRAZO_CREDITO;
//		}
//    	
//    }
	
}
