package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	public ComandoNonValido() {
		registraComando(getNome());
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido");
	}

	@Override
	public String getNome() {
		return "non valido";
	}
}