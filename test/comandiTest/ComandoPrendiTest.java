package comandiTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Test
	public void testPrendiAttrezzoPresente() {
		partita = new Partita();
		stanza = partita.getStanzaCorrente();
		attrezzo = new Attrezzo("Martello", 1);
		stanza.addAttrezzo(attrezzo);
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("Martello");
		comando.esegui(partita);
		assertFalse(stanza.hasAttrezzo("Martello"));
        assertNotNull(partita.getGiocatore().getBorsa().getAttrezzo("Martello"));
	}
	@Test
	public void testPrendiAttrezzoNonPresente() {
		partita = new Partita();
		stanza = new Stanza("Stanza");
		attrezzo = new Attrezzo("Martello", 1);
		stanza.addAttrezzo(attrezzo);
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro("Lanterna");
		comando.esegui(partita);
		assertNull(partita.getGiocatore().getBorsa().getAttrezzo("Lanterna"));
        assertTrue(stanza.hasAttrezzo("Martello"));
	}
	@Test
	public void testPrendiSenzaParametro() {
		partita = new Partita();
		stanza = new Stanza("Stanza");
		attrezzo = new Attrezzo("Martello", 1);
		stanza.addAttrezzo(attrezzo);
		ComandoPrendi comando = new ComandoPrendi();
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(stanza.hasAttrezzo("Martello"));
	}
}
