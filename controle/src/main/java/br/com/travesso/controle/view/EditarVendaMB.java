package br.com.travesso.controle.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.travesso.controle.business.BandeiraCartaoBC;
import br.com.travesso.controle.business.ClienteBC;
import br.com.travesso.controle.business.OperadoraCartaoBC;
import br.com.travesso.controle.business.VendaBC;
import br.com.travesso.controle.business.VendedorBC;
import br.com.travesso.controle.domain.BandeiraCartao;
import br.com.travesso.controle.domain.Cliente;
import br.com.travesso.controle.domain.OperadoraCartao;
import br.com.travesso.controle.domain.Pagamento;
import br.com.travesso.controle.domain.Venda;
import br.com.travesso.controle.domain.VendaVendedor;
import br.com.travesso.controle.domain.Vendedor;
import br.com.travesso.controle.exception.NegocioException;
import br.com.travesso.controle.util.ManagedBeanUtil;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.message.Message;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("/listar_vendas.xhtml")
public class EditarVendaMB extends AbstractEditPageBean<Venda, Integer> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteBC clienteBC;

	@Inject
	private OperadoraCartaoBC operadoraCartaoBC;

	@Inject
	private BandeiraCartaoBC bandeiraCartaoBC;
	
	@Inject
	private VendedorBC vendedorBC;
	
	@Inject
	private VendaBC vendaBC;	
	
	private Vendedor vendedor;
	
	private List<Pagamento> pagamentos;
	
	private List<VendaVendedor> vendasVendedores;
	
	private BigDecimal valorVendaVendedor;
	
	@PostConstruct
	public void init(){
		this.pagamentos = new ArrayList<Pagamento>();
		this.vendasVendedores = new ArrayList<VendaVendedor>();
	}
 
	@Override
	@Transactional
	public String delete() {
		this.vendaBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.vendaBC.insert(getBean());
		return getPreviousView();
	}
	
	@Transactional
	public String registrarVenda() {
		this.vendaBC.registrarVenda(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.vendaBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected Venda handleLoad(Integer id) {
		return this.vendaBC.load(id);
	}
	
	public void onClickAdicionarVendedor() throws NegocioException{
		VendaVendedor vv = new VendaVendedor();
		vv.setVenda(this.getBean());
		vv.setVendedor(this.vendedor);
		vv.setValor(this.valorVendaVendedor);
		this.vendaBC.validarInclusaoVendaVendedor(vendedor, vendasVendedores);
		this.vendasVendedores.add(vv);
	}
	
	@ExceptionHandler
	public void tratador(NegocioException ne){
		for(Message msg : ne.getMessages()){
			ManagedBeanUtil.addMessage(msg);
		}		
	}
	
	public List<Cliente> getListaClientes(){
		return clienteBC.findAll();
	}

	public List<OperadoraCartao> getListaOperadorasCartao(){
		return operadoraCartaoBC.findAll();
	}
	
	public List<BandeiraCartao> getListaBandeirasCartao(){
		return bandeiraCartaoBC.findAll();
	}
	
	public void tratarVendaComMaisDeUmVendedor(){
		
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<VendaVendedor> getVendasVendedores() {
		return vendasVendedores;
	}

	public void setVendasVendedores(List<VendaVendedor> vendasVendedores) {
		this.vendasVendedores = vendasVendedores;
	}
	
	public List<Vendedor> getListaVendedores(){
		return vendedorBC.findAll();
	}

	public BigDecimal getValorVendaVendedor() {
		return valorVendaVendedor;
	}

	public void setValorVendaVendedor(BigDecimal valorVendaVendedor) {
		this.valorVendaVendedor = valorVendaVendedor;
	}
	
//	public FormaPagamentoEnum[] getListaFormasPagamento(){
//		return FormaPagamentoEnum.values();
//	}
//	
//	public TipoCartaoEnum[] getListaTiposCartao(){
//		return TipoCartaoEnum.values();
//	}
//	
//	public PrazoPagamentoEnum[] getListaPrazosPagamento(){
//		return PrazoPagamentoEnum.values();
//	}

}
