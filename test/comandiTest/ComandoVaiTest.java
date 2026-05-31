package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private IOSimulator io;

	@BeforeEach
	public void setUp() {
		this.io = new IOSimulator(Arrays.asList());
	}

	@Test
	public void testVaiInDirezioneValida() {

		Labirinto lab =Labirinto.newBuilder()
				.addStanzaIniziale("Stanza1")
				.addStanza("Stanza2")
				.addAdiacenza("Stanza1", "Stanza2", Direzione.NORD)
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoVai comando = new ComandoVai();

		comando.setParametro("nord");
		comando.setIO(io);

		comando.esegui(partita);

		assertEquals("Stanza2",
				partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiDirezioneInesistente() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("Stanza1")
				.addStanza("Stanza2")
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoVai comando = new ComandoVai();

		comando.setParametro("sud");
		comando.setIO(io);

		comando.esegui(partita);

		assertEquals("Stanza1",
				partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiSenzaParametro() {

		Labirinto lab = Labirinto.newBuilder()
				.addStanzaIniziale("Aula")
				.getLabirinto();

		Partita partita = new Partita(lab);

		ComandoVai comando = new ComandoVai();

		comando.setParametro(null);
		comando.setIO(io);

		comando.esegui(partita);

		assertEquals("Aula",
				partita.getStanzaCorrente().getNome());
	}
}