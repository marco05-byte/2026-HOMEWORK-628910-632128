package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Giocatore giocatore;
	
	public Partita() {
		this(Labirinto.newBuilder().getLabirinto());
	}
	
	public Partita(Labirinto labirinto) {
		if (labirinto == null) {
            throw new IllegalArgumentException("Labirinto nullo");
        }
		this.labirinto = labirinto;
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.stanzaVincente = labirinto.getStanzaVincente();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

	public Labirinto getLabirinto() {
	    return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() <= 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
		this.stanzaCorrente = labirinto.getStanzaIniziale();
		this.stanzaVincente = labirinto.getStanzaVincente();
	}
}
