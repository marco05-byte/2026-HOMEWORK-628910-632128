
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;

	@BeforeEach
	public void setUp() {
		partita = new Partita();
	}

	// Test per vinta()

	@Test
	public void testVinta_InizioPartita() {
		// All'inizio il giocatore è nell'Atrio, la vincente è la Biblioteca
		assertFalse(partita.vinta());
	}

	@Test
	public void testVinta_StanzaVincenteRaggiunta() {
		Stanza vincente = partita.getLabirinto().getUscita();
		partita.setStanzaCorrente(vincente);
		assertTrue(partita.vinta());
	}

	@Test
	public void testVinta_AltraStanzaNonVincente() {
		Stanza corrente = partita.getStanzaCorrente();
		Stanza adiacente = corrente.getStanzaAdiacente("est"); // Aula N11
		partita.setStanzaCorrente(adiacente);
		assertFalse(partita.vinta());
	}

	// Test per isFinita()

	@Test
	public void testIsFinita_InizioPartita() {
		assertFalse(partita.isFinita());
	}

	@Test
	public void testIsFinita_CfuEsauriti() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinita_PartitaVinta() {
		// Se la partita è vinta, deve risultare anche finita
		Stanza vincente = partita.getLabirinto().getUscita();
		partita.setStanzaCorrente(vincente);
		assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinita_ImpostataManualmente() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
}

