package it.uniroma3.diadia;

import java.io.*;
import java.util.*;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
;

public class CaricatoreLabirinto {

	private static final String STANZE_MARKER = "Stanze:";
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";
	private static final String ATTREZZI_MARKER = "Attrezzi:";
	private static final String USCITE_MARKER = "Uscite:";

	private final BufferedReader reader;
	private final Labirinto.LabirintoBuilder builder;

	private Labirinto labirinto;

	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this(new FileReader(nomeFile));
	}

	public CaricatoreLabirinto(Reader reader) {
		this.reader = new BufferedReader(reader);
		this.builder = Labirinto.newBuilder();
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			leggiStanze();
			leggiInizioEVincente();
			leggiAttrezzi();
			leggiUscite();

			this.labirinto = builder.getLabirinto();

		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public Labirinto getLabirinto() {
		return labirinto;
	}



	private void leggiStanze() throws FormatoFileNonValidoException {
		String riga = leggiRiga(STANZE_MARKER);

		for (String nome : splitComma(riga)) {
			builder.addStanza(nome.trim());
		}
	}

	private void leggiInizioEVincente() throws FormatoFileNonValidoException {
		String inizio = leggiRiga(STANZA_INIZIALE_MARKER).trim();
		String vincente = leggiRiga(STANZA_VINCENTE_MARKER).trim();

		builder.addStanzaIniziale(inizio);
		builder.addStanzaVincente(vincente);
	}



	private void leggiAttrezzi() throws FormatoFileNonValidoException {
		String riga = leggiRiga(ATTREZZI_MARKER);

		for (String spec : splitComma(riga)) {
			String[] p = spec.trim().split("\\s+");

			check(p.length == 3, "Attrezzo malformato");

			String nome = p[0];
			int peso = Integer.parseInt(p[1]);
			String stanza = p[2];

			
			builder.addStanza(stanza);
			builder.addAttrezzo(nome, peso);
		}
	}


	private void leggiUscite() throws FormatoFileNonValidoException {
		String riga = leggiRiga(USCITE_MARKER);

		for (String spec : splitComma(riga)) {
			String[] p = spec.trim().split("\\s+");

			check(p.length == 3, "Uscita malformata");

			String da = p[0];
			String a = p[2];

			Direzione direzione;

			try {
				direzione = Direzione.valueOf(p[1].toUpperCase());
			} catch (IllegalArgumentException e) {
				throw new FormatoFileNonValidoException("Direzione non valida: " + p[1]);
			}

			builder.addAdiacenza(da, a, direzione);
		}
	}

	private String leggiRiga(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = reader.readLine();
			
			
			
			
			
			System.out.println("DEBUG: [" + riga + "]");
			
			
			
			
			
			check(riga != null && riga.startsWith(marker),
					"Atteso marker: " + marker);
			return riga.substring(marker.length()).trim();
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private List<String> splitComma(String riga) {
		List<String> res = new ArrayList<>();
		for (String s : riga.split(",")) {
			if (!s.trim().isEmpty())
				res.add(s.trim());
		}
		return res;
	}

	private void check(boolean cond, String msg) throws FormatoFileNonValidoException {
		if (!cond)
			throw new FormatoFileNonValidoException(msg);
	}
}