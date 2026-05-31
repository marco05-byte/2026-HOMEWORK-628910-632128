package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	public ComandoPosa() {
		registraComando(getNome());
	}

	@Override
	public void esegui(Partita partita) {

		String nomeAttrezzo = getParametro();

		if (nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}

		Attrezzo attrezzo = partita.getGiocatore()
				.getBorsa()
				.getAttrezzo(nomeAttrezzo);

		if (attrezzo == null) {
			io.mostraMessaggio("Non hai questo attrezzo");
			return;
		}

		partita.getGiocatore()
				.getBorsa()
				.removeAttrezzo(nomeAttrezzo);

		partita.getStanzaCorrente()
				.addAttrezzo(attrezzo);

		io.mostraMessaggio("Hai posato " + nomeAttrezzo);
	}

	@Override
	public String getNome() {
		return "posa";
	}
}