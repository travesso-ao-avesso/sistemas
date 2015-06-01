package br.com.travesso.controle.domain.enumeration;

public enum FormaPagamentoEnum {

	DINHEIRO("Dinheiro"), 
	CARTAO("Cartão"), 
	CHEQUE("Cheque");	
	private String descricao;

	private FormaPagamentoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

