
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaVuota;
	private Attrezzo osso;
	private Attrezzo lanterna;

	@BeforeEach
	public void setUp() {
		stanzaVuota = new Stanza("Stanza Vuota");
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
	}

	// Test per addAttrezzo

	@Test
	public void testAddAttrezzo_StanzaVuota() {
		assertTrue(stanzaVuota.addAttrezzo(osso));
		assertTrue(stanzaVuota.hasAttrezzo("osso"));
	}

	

	@Test
	public void testAddAttrezzo_PiuAttrezzi() {
		stanzaVuota.addAttrezzo(osso);
		stanzaVuota.addAttrezzo(lanterna);
		assertEquals(osso, stanzaVuota.getAttrezzo("osso"));
		assertEquals(lanterna, stanzaVuota.getAttrezzo("lanterna"));
	}

	// Test per hasAttrezzo

	@Test
	public void testHasAttrezzo_AssenteInStanzaVuota() {
		assertFalse(stanzaVuota.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo_Presente() {
		stanzaVuota.addAttrezzo(osso);
		assertTrue(stanzaVuota.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo_AssenteMaAltriPresenti() {
		stanzaVuota.addAttrezzo(lanterna);
		assertFalse(stanzaVuota.hasAttrezzo("osso"));
	}

	// Test per removeAttrezzo

	@Test
	public void testRemoveAttrezzo_Esistente() {
		stanzaVuota.addAttrezzo(osso);
		assertTrue(stanzaVuota.removeAttrezzo(osso));
		assertFalse(stanzaVuota.hasAttrezzo("osso"));
	}

	@Test
	public void testRemoveAttrezzo_NonEsistente() {
		stanzaVuota.addAttrezzo(lanterna);
		assertFalse(stanzaVuota.removeAttrezzo(osso)); // Provo a rimuovere un attrezzo non presente
	}

	@Test
	public void testRemoveAttrezzo_DaStanzaVuota() {
		assertFalse(stanzaVuota.removeAttrezzo(osso));
	}
}








