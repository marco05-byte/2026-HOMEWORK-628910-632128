package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class Stanza {

	private String nome;
	private AbstractPersonaggio personaggio;

	private Map<String, Attrezzo> attrezzi;
	private Map<Direzione, Stanza> stanzeAdiacenti;

	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>();
	}

	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	public Stanza getStanzaAdiacente(Direzione direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.toString();
	}

	public Map<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;

		String nome = attrezzo.getNome();

		if (this.attrezzi.containsKey(nome))
			return false;

		this.attrezzi.put(nome, attrezzo);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();

		risultato.append(this.nome);
		risultato.append("\nUscite: ");

		for (Direzione direzione : this.stanzeAdiacenti.keySet()) {
			if (direzione != null) {
				risultato.append(" ").append(direzione);
			}
		}

		risultato.append("\nAttrezzi nella stanza: ");

		for (Attrezzo attrezzo : this.attrezzi.values()) {
			if (attrezzo != null) {
				risultato.append(attrezzo.toString()).append(" ");
			}
		}

		return risultato.toString();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;

		return this.attrezzi.remove(attrezzo.getNome()) != null;
	}

	// 🔴 FIX IMPORTANTE: prima era sbagliato (String)
	public Direzione[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new Direzione[0]);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Stanza other = (Stanza) obj;

		return this.nome.equals(other.nome);
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	// ❗ QUESTO ERA SBAGLIATO: Map<String, Stanza>
	// DEVE ESSERE coerente con enum
	public Map<Direzione, Stanza> getStanzeAdiacenti() {
		return this.stanzeAdiacenti;
	}

	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}

	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
}