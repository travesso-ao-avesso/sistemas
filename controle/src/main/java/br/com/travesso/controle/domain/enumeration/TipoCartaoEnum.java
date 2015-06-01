package br.com.travesso.controle.domain.enumeration;

public enum TipoCartaoEnum {

	CREDITO("Crédito"), 
	DEBITO("Débito");
	
	private String descricao;

	private TipoCartaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}

