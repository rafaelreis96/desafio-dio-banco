package dev.rafaelreis.banco;

public class Banco {

	private String nome;

	private Banco(String nome) {
		this.nome = nome;
	}

	public static Banco of(String nome) {
		return new Banco(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
