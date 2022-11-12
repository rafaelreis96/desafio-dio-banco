package dev.rafaelreis.banco;

public class ContaCorrente extends Conta {
 
	private ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public static ContaCorrente of(Cliente cliente) { 		
		return new ContaCorrente(cliente);
	}
	
	@Override
	public void imprimirExtrado() {
		System.out.println("::: Extrato Conta Corrente :::");
		super.imprimirExtrado();
	}

}
