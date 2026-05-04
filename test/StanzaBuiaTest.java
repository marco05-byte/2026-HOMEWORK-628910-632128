import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;

    @BeforeEach
    public void setUp() {
        stanza = new StanzaBuia("caverna", "lanterna");
    }
    @Test
    public void testDescrizioneSenzaLanterna() {
        String descrizione = stanza.getDescrizione();

        assertEquals("qui c'è un buio pesto", descrizione);
    }
    @Test
    public void testDescrizioneConLanterna() {
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));

        String descrizione = stanza.getDescrizione();

        assertNotEquals("qui c'è un buio pesto", descrizione);
        assertTrue(descrizione.contains("caverna"));
    }
    @Test
    public void testDescrizioneConAttrezzoDiverso() {
        stanza.addAttrezzo(new Attrezzo("osso", 1));

        String descrizione = stanza.getDescrizione();

        assertEquals("qui c'è un buio pesto", descrizione);
    }
}
