package br.com.travesso.controle.domain.enumeration;


public enum PrazoPagamentoEnum {

	A_VISTA("À vista"), 
	PARCELADO("Parcelado");
	
	private String descricao;

	private PrazoPagamentoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}