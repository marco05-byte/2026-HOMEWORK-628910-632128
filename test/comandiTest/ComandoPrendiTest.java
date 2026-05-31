package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private IOSimulator io;

	@BeforeEach
	public void setUp() {
		this.io = new IOSimulator(Arrays.asList());
	}

	@Test
	public void testPrendiAttrezzoMonolocale() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("Aula")
				.addStanzaVincente("Aula")
				.addAttrezzo("martello", 1)
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoPrendi comando = new ComandoPrendi();

		comando.setParametro("martello");
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getGiocatore()
						.getBorsa()
						.hasAttrezzo("martello"));

		assertFalse(
				partita.getStanzaCorrente()
						.hasAttrezzo("martello"));
	}

	@Test
	public void testPrendiAttrezzoBilocale() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.addStanza("B")
				.addAttrezzo("chiave", 1)
				.addAdiacenza("A", "B", Direzione.NORD)
				.getLabirinto();

		Partita partita = new Partita(lab);

		partita.setStanzaCorrente(
				lab.getStanzaIniziale()
						.getStanzaAdiacente(Direzione.NORD));

		ComandoPrendi comando = new ComandoPrendi();

		comando.setParametro("chiave");
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getGiocatore()
						.getBorsa()
						.hasAttrezzo("chiave"));
	}

	@Test
	public void testPrendiAttrezzoNonPresente() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoPrendi comando = new ComandoPrendi();

		comando.setParametro("spada");
		comando.setIO(io);

		comando.esegui(partita);

		assertFalse(
				partita.getGiocatore()
						.getBorsa()
						.hasAttrezzo("spada"));
	}

	@Test
	public void testPrendiSenzaParametro() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("A")
				.addAttrezzo("lanterna", 2)
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoPrendi comando = new ComandoPrendi();

		comando.setParametro(null);
		comando.setIO(io);

		comando.esegui(partita);

		assertTrue(
				partita.getStanzaCorrente()
						.hasAttrezzo("lanterna"));
	}
}