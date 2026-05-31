package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;

public class AbstractComandoTest {

	private ComandoFinto comando;

	private IOSimulator io;

	@BeforeEach
	public void setUp() {

		this.comando = new ComandoFinto();

		this.io = new IOSimulator(Arrays.asList());
	}

	@Test
	public void testSetParametro() {

		comando.setParametro("nord");

		assertEquals("nord", comando.getParametro());
	}

	@Test
	public void testSetIO() {

		comando.setIO(io);

		assertNotNull(comando.getIO());
	}

	/*
	 * Classe finta per testare AbstractComando
	 */
	private class ComandoFinto extends AbstractComando {

		@Override
		public void esegui(Partita partita) {
		}

		@Override
		public String getNome() {
			return "finto";
		}

		public IO getIO() {
			return this.io;
		}
	}
}