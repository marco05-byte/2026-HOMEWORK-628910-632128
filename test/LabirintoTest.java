import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;

class LabirintoTest {

    @Test
    void testLabirintoBuilderBase() {

        Labirinto lab = Labirinto.newBuilder()
                .addStanzaIniziale("entrata")
                .addStanza("corridoio")
                .addStanzaVincente("uscita")
                .addAdiacenza("entrata", "corridoio", Direzione.NORD)
                .getLabirinto();

        assertNotNull(lab.getStanzaIniziale());
        assertNotNull(lab.getStanzaVincente());

        assertEquals("entrata", lab.getStanzaIniziale().getNome());
        assertEquals("uscita", lab.getStanzaVincente().getNome());
    }
    @Test
    void testAdiacenza() {

        Labirinto lab = Labirinto.newBuilder()
                .addStanzaIniziale("A")
                .addStanza("B")
                .addAdiacenza("A", "B", Direzione.NORD)
                .getLabirinto();

        Stanza a = lab.getStanzaIniziale();
        Stanza b = lab.getStanze().get("B");

        assertEquals(b, a.getStanzaAdiacente(Direzione.NORD));
    }
    @Test
    void testAttrezzo() {

        Labirinto lab = Labirinto.newBuilder()
                .addStanzaIniziale("A")
                .addAttrezzo("osso", 1)
                .getLabirinto();

        Stanza a = lab.getStanzaIniziale();

        assertTrue(a.hasAttrezzo("osso"));
    }
    @Test
    void testPartitaInizializzazione() {

        Labirinto lab = Labirinto.newBuilder()
                .addStanzaIniziale("A")
                .addStanzaVincente("B")
                .getLabirinto();

        Partita p = new Partita(lab);

        assertEquals(p.getStanzaCorrente(), lab.getStanzaIniziale());
    }
}