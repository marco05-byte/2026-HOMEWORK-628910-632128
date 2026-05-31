package comandiTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

class FabbricaDiComandiRiflessivaTest {

	private FabbricaDiComandiRiflessiva fabbrica;

	@BeforeEach
	void setUp() {
		this.fabbrica = new FabbricaDiComandiRiflessiva();
	}

	@Test
	void testComandoVai() throws Exception {

		Comando comando = fabbrica.costruisciComando("vai nord");

		assertTrue(comando instanceof ComandoVai);
		assertEquals("nord", comando.getParametro());
	}

	@Test
	void testComandoNonValido() throws Exception {

		Comando comando = fabbrica.costruisciComando("blabla");

		assertTrue(comando instanceof ComandoNonValido);
	}

	@Test
	void testComandoVuoto() throws Exception {

		Comando comando = fabbrica.costruisciComando("");

		assertTrue(comando instanceof ComandoNonValido);
	}
}