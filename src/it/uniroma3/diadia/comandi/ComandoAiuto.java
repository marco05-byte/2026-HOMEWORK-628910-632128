package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	public ComandoAiuto() {
		registraComando(getNome());
	}
	@Override
	public void esegui(Partita partita) {

		io.mostraMessaggio("Comandi disponibili:");

		for (String comando : getComandiDisponibili()) {
			io.mostraMessaggio("- " + comando);
		}
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

}
