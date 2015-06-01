package br.com.travesso.controle.util;

public final class Constantes {

	public static interface TAMANHOS {
		public static final int PRAZO_DEBITO = 1;
		public static final int PRAZO_CREDITO = 30;
	}
	
	/**
	 * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
	 * and so on. Thus, the caller should be prevented from constructing objects
	 * of this class, by declaring this private constructor.
	 */
	private Constantes() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}

}
