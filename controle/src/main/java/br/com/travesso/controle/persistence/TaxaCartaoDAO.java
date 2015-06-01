package br.com.travesso.controle.persistence;

import javax.persistence.Query;

import br.com.travesso.controle.domain.BandeiraCartao;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.com.travesso.controle.domain.TaxaCartao;
import br.com.travesso.controle.domain.enumeration.PrazoPagamentoEnum;
import br.com.travesso.controle.domain.enumeration.TipoCartaoEnum;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class TaxaCartaoDAO extends JPACrud<TaxaCartao, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	public TaxaCartao obterTaxaCartao(OperadoraCartao operadora, BandeiraCartao bandeira, TipoCartaoEnum tipo, PrazoPagamentoEnum prazo, int parcelas){
		Query query = getEntityManager().createQuery("select t from TaxaCartao t where t.operadora = :operadora and t.bandeira = :bandeira and t.tipoCartao = :tipo and t.prazoPagamento = :prazo and t.parcelas = :parcelas");
		query.setParameter("operadora", operadora);
		query.setParameter("bandeira", bandeira);
		query.setParameter("tipo", tipo);
		query.setParameter("prazo", prazo);
		query.setParameter("parcelas", parcelas);
		return (TaxaCartao) query.getSingleResult();
	}
	
}
