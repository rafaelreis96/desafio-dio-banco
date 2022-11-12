package dev.rafaelreis.banco;

import java.math.BigDecimal;

import com.github.javafaker.Faker;

public abstract class Conta implements IConta {

	private String agencia;
	private String numero;
	private BigDecimal saldo;
	private Banco banco;
	private Cliente cliente;
	
	{
		this.agencia = Faker.instance().number().digits(4);
		this.numero  = Faker.instance().number().digits(6);
		this.saldo 	 = BigDecimal.ZERO;
		this.banco 	 = Banco.of("Banco DIO");
	}

	Conta(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void sacar(BigDecimal valor) {
		this.saldo = this.saldo.subtract(valor);
		System.out.printf("[%s]-> Saque realizado no valor de R$%.2f\n\n", this.cliente.getNome(), valor.doubleValue());
	}

	@Override
	public void depositar(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
		System.out.printf("[%s]-> Deposito realizado no valor de R$%.2f\n\n", this.cliente.getNome(), valor.doubleValue());
	}

	@Override
	public void transferir(BigDecimal valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.printf(
				"[%s]-> Transferencia realizada no valor de R$%.2f\n"
				+ "%s(Depositante) -> %s(Recebedor)\n\n",
				this.cliente.getNome(),
				valor.doubleValue(), 
				this.cliente.getNome(), 
				contaDestino.getCliente().getNome());
	}

	@Override
	public void imprimirExtrado() {
		String extrato = String.format(
				  "Titular: %s\n"
				+ "Agencia: %s\n"
				+ "Conta  : %s\n"
				+ "Saldo  : R$%.2f\n", 
				cliente.getNome(), 
				agencia, 
				numero, 
				saldo.doubleValue());

		System.out.println(extrato);
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public Banco getBanco() {
		return banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
