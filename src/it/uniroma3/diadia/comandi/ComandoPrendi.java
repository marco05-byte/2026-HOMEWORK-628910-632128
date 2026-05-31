package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	public ComandoPrendi() {
		registraComando(getNome());
	}

	@Override
	public void esegui(Partita partita) {

		String nomeAttrezzo = getParametro();

		if (nomeAttrezzo == null) {
			io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente()
				.getAttrezzo(nomeAttrezzo);

		if (attrezzo == null) {
			io.mostraMessaggio("Attrezzo non presente");
			return;
		}

		partita.getStanzaCorrente()
				.removeAttrezzo(attrezzo);

		partita.getGiocatore()
				.getBorsa()
				.addAttrezzo(attrezzo);

		io.mostraMessaggio("Hai preso " + nomeAttrezzo);
	}

	@Override
	public String getNome() {
		return "prendi";
	}
}