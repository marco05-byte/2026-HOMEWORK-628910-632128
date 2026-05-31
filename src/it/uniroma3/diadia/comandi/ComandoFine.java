package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	public ComandoFine() {
		registraComando(getNome());
	}
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
	}

	@Override
	public String getNome() {
		return "fine";
	}
}