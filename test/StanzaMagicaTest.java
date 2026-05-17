import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	private StanzaMagica stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        stanza = new StanzaMagica("magica", 2); 
        attrezzo = new Attrezzo("chiave", 2);
    }
    @Test
    public void testAddAttrezzoNonMagico() {
        stanza.addAttrezzo(attrezzo);
        Attrezzo trovato = stanza.getAttrezzo("chiave");
        assertNotNull(trovato);
        assertEquals("chiave", trovato.getNome());
        assertEquals(2, trovato.getPeso());
    }
    @Test
    public void testAddAttrezzoMagico() {
        stanza.addAttrezzo(new Attrezzo("osso", 1));     
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));
        stanza.addAttrezzo(attrezzo);                  
        Attrezzo modificato = stanza.getAttrezzo("evaihc");
        assertNotNull(modificato);
        assertEquals("evaihc", modificato.getNome());
        assertEquals(4, modificato.getPeso()); 
    }
    @Test
    public void testAttrezzoOriginaleNonPresenteDopoMagia() {
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        stanza.addAttrezzo(new Attrezzo("lanterna", 3));
        stanza.addAttrezzo(attrezzo); 
        assertNull(stanza.getAttrezzo("chiave"));
    }
    @Test
    public void testNonMagicoPrimaDellaSoglia() {
        stanza.addAttrezzo(new Attrezzo("osso", 1));
        stanza.addAttrezzo(attrezzo);
        Attrezzo trovato = stanza.getAttrezzo("chiave");
        assertNotNull(trovato);
        assertEquals(2, trovato.getPeso());
    }
    @Test
    public void testCapienzaMassima() {
        for(int i = 0; i < 10; i++) {
            stanza.addAttrezzo(new Attrezzo("a"+i, 1));
        }
        boolean risultato = stanza.addAttrezzo(new Attrezzo("extra", 1));
        assertFalse(risultato);
    }
}
