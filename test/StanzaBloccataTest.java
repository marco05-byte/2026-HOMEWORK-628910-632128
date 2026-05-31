import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata stanza;
    private Stanza stanzaNord;

    @BeforeEach
    public void setUp() {
        stanza = new StanzaBloccata("atrio", Direzione.NORD, "passepartout");
        stanzaNord = new Stanza("biblioteca");

        stanza.impostaStanzaAdiacente(Direzione.NORD, stanzaNord);
    }
    @Test
    public void testDirezioneBloccataSenzaAttrezzo() {
        Stanza risultato = stanza.getStanzaAdiacente(Direzione.NORD);

        assertEquals(stanza, risultato); 
    }
    @Test
    public void testDirezioneSbloccataConAttrezzo() {
        stanza.addAttrezzo(new Attrezzo("passepartout", 1));

        Stanza risultato = stanza.getStanzaAdiacente(Direzione.NORD);

        assertEquals(stanzaNord, risultato);
    }
    @Test
    public void testDirezioneNonBloccata() {
        Stanza est = new Stanza("cucina");
        stanza.impostaStanzaAdiacente(Direzione.EST, est);

        Stanza risultato = stanza.getStanzaAdiacente(Direzione.EST);

        assertEquals(est, risultato);
    }
    @Test
    public void testDescrizioneContieneDirezioneBloccata() {
        String descrizione = stanza.getDescrizione();

        assertTrue(descrizione.contains("nord"));
    }
}
