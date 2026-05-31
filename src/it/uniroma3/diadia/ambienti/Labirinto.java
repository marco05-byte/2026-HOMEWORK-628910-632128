package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza entrata;
	private Stanza uscita;
	private Map<String, Stanza> stanze;

	
	private Labirinto() {
		this.stanze = new HashMap<>();
	}

	public Stanza getStanzaIniziale() {
		return entrata;
	}

	public Stanza getStanzaVincente() {
		return uscita;
	}

	public void setEntrata(Stanza entrata) {
		this.entrata = entrata;
	}

	public void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}

	public Map<String, Stanza> getStanze() {
		return this.stanze;
	}

	public void addStanza(Stanza stanza) {
		this.stanze.put(stanza.getNome(), stanza);
	}

	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	public static class LabirintoBuilder {

		private Labirinto labirinto;
		private Map<String, Stanza> listaStanze;
		private Stanza ultimaStanzaAggiunta;

		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.listaStanze = new HashMap<>();
		}

		public LabirintoBuilder addStanza(String nomeStanza) {

			if (!listaStanze.containsKey(nomeStanza)) {

				Stanza stanza = new Stanza(nomeStanza);

				listaStanze.put(nomeStanza, stanza);
				labirinto.addStanza(stanza);

				ultimaStanzaAggiunta = stanza;
			}

			return this;
		}

		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {

			addStanza(nomeStanza);
			labirinto.setEntrata(listaStanze.get(nomeStanza));

			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanza) {

			addStanza(nomeStanza);
			labirinto.setUscita(listaStanze.get(nomeStanza));

			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {

			if (ultimaStanzaAggiunta != null) {
				Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
				ultimaStanzaAggiunta.addAttrezzo(attrezzo);
			}

			return this;
		}

		public LabirintoBuilder addAdiacenza(String da,
				String a,
				Direzione direzione) {

			Stanza partenza = listaStanze.get(da);
			Stanza arrivo = listaStanze.get(a);

			if (partenza != null && arrivo != null) {
				partenza.impostaStanzaAdiacente(direzione, arrivo);
			}

			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}
	}
}