package dev.rafaelreis.banco;

public class ContaPoupanca extends Conta {
	
	private ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	public static ContaPoupanca of(Cliente cliente) {
		return new ContaPoupanca(cliente);
	}
	
	@Override
	public void imprimirExtrado() {
		System.out.println("::: Extrato Conta Poupança :::");
		super.imprimirExtrado();
	}
}
