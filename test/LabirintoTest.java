import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	@Test
	public void entrataTest() {
		Labirinto l = new Labirinto();
		assertNotNull(l.getEntrata());
	}
	@Test
	public void entrataUscitaTest() {
		Labirinto l = new Labirinto();
		assertNotEquals(l.getEntrata(), l.getUscita());
	}
	@Test
	public void collegamentoTest() {
		Labirinto l = new Labirinto();
		Stanza nord = l.getEntrata().getStanzaAdiacente("nord");
		assertNotNull(nord);
		assertEquals("Biblioteca", nord.getNome());
	}
	@Test
	public void testEntrataHaUsciteValide() {
		Labirinto l = new Labirinto();
		Stanza entrata = l.getEntrata();
		assertNotNull(entrata.getStanzaAdiacente("nord"));
	}
	@Test
	public void testDirezioneNonValida() {
		Labirinto l = new Labirinto();
		Stanza entrata = l.getEntrata();
		assertNull(entrata.getStanzaAdiacente("alto"));
	}
	@Test
	public void testStanzaInizialeNotNull() {
		Labirinto l = new Labirinto();
		assertNotNull(l.getEntrata());
	}
	@Test
	public void testStanzaFinaleNotNull() {
		Labirinto l = new Labirinto();
		assertNotNull(l.getUscita());
	}
}
