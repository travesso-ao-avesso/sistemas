package br.com.travesso.controle.domain.factory;

import br.com.travesso.controle.domain.Pagamento;
import br.com.travesso.controle.domain.PagamentoCartao;
import br.com.travesso.controle.domain.PagamentoDinheiro;
import br.com.travesso.controle.domain.enumeration.FormaPagamentoEnum;

public class PagamentoSimpleFactory {
	
    static private PagamentoSimpleFactory singletonFactory;
    
    // private constructor, we don't want the class to be instantiated from
    // others.
    private PagamentoSimpleFactory() {
    }
 
    /**
     * Singleton Getter
     */
    public static PagamentoSimpleFactory getSingletonFactory() {
		if (singletonFactory == null) {
		    synchronized (singletonFactory) {
				if (singletonFactory == null) {
				    singletonFactory = new PagamentoSimpleFactory();
				}
		    }
		}
	return singletonFactory;
    }

    public Pagamento criaPagamento(FormaPagamentoEnum formaPgto){
    	Pagamento pagamento = null;
    	if(formaPgto.equals(FormaPagamentoEnum.DINHEIRO)){
    		pagamento = new PagamentoDinheiro();
    	} else if(formaPgto.equals(FormaPagamentoEnum.CARTAO)){
    		pagamento = new PagamentoCartao();
    	}
    	return pagamento;
    }
}
