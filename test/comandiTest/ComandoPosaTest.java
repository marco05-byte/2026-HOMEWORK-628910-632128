package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private IOSimulator io;

	@BeforeEach
	public void setUp() {
		this.io = new IOSimulator(Arrays.asList());
	}

	@Test
	public void testPosaAttrezzoMonolocale() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("Stanza")
				.addStanzaVincente("Stanza")
				.getLabirinto();

		Partita partita = new Partita(lab);

		partita.getGiocatore()
				.getBorsa()
				.addAttrezzo(new Attrezzo("lanterna", 2));

		ComandoPosa comando = new ComandoPosa();

		comando.setParametro("lanterna");
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getStanzaCorrente()
						.hasAttrezzo("lanterna"));
	}

	@Test
	public void testPosaAttrezzoBilocale() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.addStanza("B")
				.addAdiacenza("A", "B", Direzione.NORD)
				.getLabirinto();

		Partita partita = new Partita(lab);

		partita.getGiocatore()
				.getBorsa()
				.addAttrezzo(new Attrezzo("chiave", 1));

		ComandoPosa comando = new ComandoPosa();

		comando.setParametro("chiave");
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getStanzaCorrente()
						.hasAttrezzo("chiave"));
	}

	@Test
	public void testPosaAttrezzoNonPresente() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoPosa comando = new ComandoPosa();

		comando.setParametro("spada");
		comando.setIO(io);

		comando.esegui(partita);

		assertFalse(
				partita.getStanzaCorrente()
						.hasAttrezzo("spada"));
	}

	@Test
	public void testPosaSenzaParametro() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.getLabirinto();

		Partita partita = new Partita(lab);

		partita.getGiocatore()
				.getBorsa()
				.addAttrezzo(new Attrezzo("lanterna", 2));

		ComandoPosa comando = new ComandoPosa();

		comando.setParametro(null);
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getGiocatore()
						.getBorsa()
						.hasAttrezzo("lanterna"));
	}
}