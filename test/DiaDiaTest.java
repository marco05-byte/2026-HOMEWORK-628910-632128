import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class DiaDiaTest {

    @Test
    public void testAiutoStampaComandi() {
        String[] input = {
            "aiuto",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean trovato = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.contains("Comandi disponibili")) {
                trovato = true;
            }
        }

        assertTrue(trovato);
    }
    
    @Test
    public void testVittoria() {
        String[] input = {
            "vai nord"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean vinto = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.contains("Hai vinto")) {
                vinto = true;
            }
        }

        assertTrue(vinto);
    }
    
    @Test
    public void testComandoNonValido() {
        String[] input = {
            "xyz",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean trovato = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.toLowerCase().contains("non valido")) {
                trovato = true;
            }
        }

        assertTrue(trovato);
    }
    
    @Test
    public void testSequenzaComandi() {
        String[] input = {
            "guarda",
            "vai est",
            "vai ovest",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        assertFalse(io.getOutput().isEmpty());
    }
    
    @Test
    public void testMovimentoMostraNuovaStanza() {
        String[] input = {
            "vai est",   
            "guarda",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean trovato = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.contains("Aula N11")) {
                trovato = true;
            }
        }

        assertTrue(trovato);
    }
    
    @Test
    public void testPrendiAttrezzo() {
        String[] input = {
            "vai sud",        // Atrio → Aula N10
            "prendi lanterna",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean trovato = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.toLowerCase().contains("hai preso lanterna")) {
                trovato = true;
            }
        }

        assertTrue(trovato);
    }
    
    @Test
    public void testPosaAttrezzo() {
        String[] input = {
            "vai sud",
            "prendi lanterna",
            "posa lanterna",
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        boolean trovato = false;

        for (String msg : io.getOutput()) {
            if (msg != null && msg.toLowerCase().contains("hai posato lanterna")) {
                trovato = true;
            }
        }

        assertTrue(trovato);
    }
    
    @Test
    public void testFinePartita() {
        String[] input = {
            "fine"
        };

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        // se arriva qui senza loop infinito → OK
        assertTrue(true);
    }
}
