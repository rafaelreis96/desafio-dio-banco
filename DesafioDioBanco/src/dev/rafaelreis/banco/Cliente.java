package dev.rafaelreis.banco;

public class Cliente {

	private String nome;

	private Cliente(String nome) {
		this.nome = nome;
	}

	public static Cliente of(String nome) {
		return new Cliente(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
