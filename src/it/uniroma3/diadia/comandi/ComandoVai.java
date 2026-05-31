package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	public ComandoVai() {
		registraComando(getNome());
	}

	@Override
	public void esegui(Partita partita) {

		String parametro = getParametro();

		if (parametro == null) {
			io.mostraMessaggio("Dove vuoi andare?");
			io.mostraMessaggio("Devi specificare una direzione");
			return;
		}

		Direzione direzione;

		try {
			direzione = Direzione.valueOf(parametro.toUpperCase());
		} catch (IllegalArgumentException e) {
			io.mostraMessaggio("Direzione non valida");
			return;
		}

		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);

		if (prossimaStanza == null) {
			io.mostraMessaggio("Non puoi andare in quella direzione");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);

		io.mostraMessaggio(partita.getStanzaCorrente().getNome());

		partita.getGiocatore().setCfu(
			partita.getGiocatore().getCfu() - 1
		);
	}

	@Override
	public String getNome() {
		return "vai";
	}
}