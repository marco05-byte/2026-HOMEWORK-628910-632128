package comandiTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandi fabbrica;

    @BeforeEach
    void setUp() {
        fabbrica = new FabbricaDiComandiFisarmonica();
    }
    @Test
    void testComandoVaiConParametro() {
        Comando c = fabbrica.costruisciComando("vai nord");
        assertEquals("vai", c.getNome());
        assertEquals("nord", c.getParametro());
    }
    @Test
    void testComandoPrendi() {
        Comando c = fabbrica.costruisciComando("prendi chiave");
        assertEquals("prendi", c.getNome());
        assertEquals("chiave", c.getParametro());
    }
    @Test
    void testComandoPosa() {
        Comando c = fabbrica.costruisciComando("posa zaino");
        assertEquals("posa", c.getNome());
        assertEquals("zaino", c.getParametro());
    }
    @Test
    void testComandoSenzaParametro() {
        Comando c = fabbrica.costruisciComando("aiuto");
        assertEquals("aiuto", c.getNome());
        assertNull(c.getParametro());
    }
}
