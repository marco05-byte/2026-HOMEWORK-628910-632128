package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	public ComandoGuarda() {
		registraComando(getNome());
	}
	@Override
	public void esegui(Partita partita) {

		io.mostraMessaggio(
				partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public String getNome() {
		return "guarda";
	}
}