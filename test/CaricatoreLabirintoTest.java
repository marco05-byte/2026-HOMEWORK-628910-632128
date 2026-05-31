


import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.Labirinto;

public class CaricatoreLabirintoTest {

	@Test
	public void testMonolocale() throws Exception {

		String input =
			"Stanze: A\n" +
			"Inizio: A\n" +
			"Vincente: A\n" +
			"Attrezzi:\n" +
			"Uscite:\n";

		CaricatoreLabirinto c = new CaricatoreLabirinto(new StringReader(input));
		c.carica();

		Labirinto l = c.getLabirinto();

		assertNotNull(l.getStanzaIniziale());
		assertNotNull(l.getStanzaVincente());
		assertEquals(l.getStanzaIniziale(), l.getStanzaVincente());
	}

	@Test
	public void testBilocaleConUscita() throws Exception {

		String input =
			"Stanze: A, B\n" +
			"Inizio: A\n" +
			"Vincente: B\n" +
			"Attrezzi:\n" +
			"Uscite: A nord B\n";

		CaricatoreLabirinto c = new CaricatoreLabirinto(new StringReader(input));
		c.carica();

		Labirinto l = c.getLabirinto();

		assertEquals("A", l.getStanzaIniziale().getNome());
		assertEquals("B", l.getStanzaVincente().getNome());
	}
}
