package dev.rafaelreis.banco;

import java.math.BigDecimal;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Main {
	public static void main(String[] args) {
		final Faker faker = Faker.instance(new Locale("pt", "BR"));
		
 		Conta conta1 = ContaCorrente.of(Cliente.of(faker.name().fullName()));
 		conta1.depositar(new BigDecimal(100.00));
 		conta1.imprimirExtrado();
		
 		Conta conta2 = ContaCorrente.of(Cliente.of(faker.name().fullName()));
 		conta2.depositar(new BigDecimal(100.00));
 		conta2.imprimirExtrado();
 		
 		conta1.transferir(new BigDecimal(30), conta2);

 		conta1.imprimirExtrado();
 		conta2.imprimirExtrado();
 
	}
}
