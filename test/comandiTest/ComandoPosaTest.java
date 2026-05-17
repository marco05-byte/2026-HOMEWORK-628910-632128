package comandiTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	private Partita partita;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        partita = new Partita();
        stanza = new Stanza("Stanza");
        attrezzo = new Attrezzo("lanterna", 2);
        partita.setStanzaCorrente(stanza);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
    }
    @Test
    public void testPosaAttrezzoPresente() {
        ComandoPosa comando = new ComandoPosa();
        comando.setParametro("lanterna");
        comando.esegui(partita);
        assertTrue(stanza.hasAttrezzo("lanterna"));
        
    }
    @Test
    public void testPosaAttrezzoNonPresente() {
        ComandoPosa comando = new ComandoPosa();
        comando.setParametro("spada");
        comando.esegui(partita);
        assertFalse(stanza.hasAttrezzo("spada"));
    }
    @Test
    public void testPosaSenzaParametro() {
        ComandoPosa comando = new ComandoPosa();
        comando.setParametro(null);
        comando.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
    }
}
