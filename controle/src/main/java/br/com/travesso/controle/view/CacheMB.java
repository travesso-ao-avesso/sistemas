package br.com.travesso.controle.view;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.travesso.controle.domain.enumeration.FormaPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.PrazoPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.TipoCartaoEnum;

@ManagedBean
@ApplicationScoped
public class CacheMB {
	
	public FormaPagamentoEnum[] getListaFormasPagamento(){
		return FormaPagamentoEnum.values();
	}
	
	public TipoCartaoEnum[] getListaTiposCartao(){
		return TipoCartaoEnum.values();
	}
	
	public PrazoPagamentoEnum[] getListaPrazosPagamento(){
		return PrazoPagamentoEnum.values();
	}
	
}
