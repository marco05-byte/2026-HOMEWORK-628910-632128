import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	private Labirinto.LabirintoBuilder builder;

	@Before
	public void setUp() {
		this.builder = Labirinto.newBuilder();
	}

	@Test
	public void testMonolocale() {

		Labirinto labirinto = builder
				.addStanzaIniziale("salotto")
				.addStanzaVincente("salotto")
				.getLabirinto();

		assertEquals("salotto",
				labirinto.getStanzaIniziale().getNome());

		assertEquals("salotto",
				labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testBilocaleConAdiacenza() {

		Labirinto labirinto = builder
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "camera", Direzione.NORD)
				.getLabirinto();

		assertEquals("camera",
				labirinto.getStanzaIniziale()
				.getStanzaAdiacente(Direzione.NORD)
				.getNome());
	}

	@Test
	public void testAggiuntaAttrezzo() {

		Labirinto labirinto = builder
				.addStanzaIniziale("salotto")
				.addAttrezzo("spada", 10)
				.getLabirinto();

		assertTrue(
				labirinto.getStanzaIniziale()
				.hasAttrezzo("spada"));

		assertEquals(
				new Attrezzo("spada", 10),
				labirinto.getStanzaIniziale()
				.getAttrezzo("spada"));
	}

	@Test
	public void testAttrezzoDuplicato() {

		Labirinto labirinto = builder
				.addStanzaIniziale("salotto")
				.addAttrezzo("spada", 10)
				.addAttrezzo("spada", 10)
				.getLabirinto();

		assertEquals(1,
				labirinto.getStanzaIniziale()
				.getAttrezzi()
				.size());
	}

	@Test
	public void testTrilocale() {

		Labirinto labirinto = builder
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", Direzione.NORD)
				.addAdiacenza("cucina", "camera", Direzione.EST)
				.getLabirinto();

		assertEquals("cucina",
				labirinto.getStanzaIniziale()
				.getStanzaAdiacente(Direzione.NORD)
				.getNome());

		assertEquals("camera",
				labirinto.getStanzaIniziale()
				.getStanzaAdiacente(Direzione.NORD)
				.getStanzaAdiacente(Direzione.EST)
				.getNome());
	}

	@Test
	public void testStanzaDuplicata() {

		builder
		.addStanza("A")
		.addStanza("A");

		assertEquals(1,
				builder.getLabirinto().getStanze().size());

	}

	@Test
	public void testAttrezzoSuUltimaStanzaAggiunta() {

		builder
		.addStanza("A")
		.addStanza("B")
		.addAttrezzo("chiave", 1);

		assertFalse(
	            builder.getLabirinto()
	                .getStanze()
	                .get("A")
	                .hasAttrezzo("chiave"));

	    assertTrue(
	            builder.getLabirinto()
	                .getStanze()
	                .get("B")
	                .hasAttrezzo("chiave"));
	}

	@Test
	public void testCambioStanzaIniziale() {

		Labirinto labirinto = builder
				.addStanzaIniziale("A")
				.addStanza("B")
				.addStanzaIniziale("B")
				.getLabirinto();

		assertEquals("B",
				labirinto.getStanzaIniziale()
				.getNome());
	}

	@Test
	public void testPiuDiQuattroAdiacenze() {

		builder
		.addStanza("A")
		.addStanza("B")
		.addStanza("C")
		.addStanza("D")
		.addStanza("E")
		.addStanza("F")

		.addAdiacenza("A", "B", Direzione.NORD)
		.addAdiacenza("A", "C", Direzione.SUD)
		.addAdiacenza("A", "D", Direzione.EST)
		.addAdiacenza("A", "E", Direzione.OVEST);

		Stanza stanzaA =
				builder.getLabirinto().getStanze().get("A");

		assertEquals(4,
				stanzaA.getDirezioni().length);
	}

	@Test
	public void testMethodChaining() {

		Labirinto.LabirintoBuilder risultato =
				builder
				.addStanza("A")
				.addStanza("B")
				.addAttrezzo("spada", 1);

		assertEquals(builder, risultato);
	}
}