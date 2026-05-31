import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;

public class DiaDiaTest {

    @Test
    public void testAiutoStampaComandi() {

        List<String> input = Arrays.asList(
                "aiuto",
                "fine"
        );

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

        List<String> input = Arrays.asList(
                "vai nord"
        );

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

        List<String> input = Arrays.asList(
                "xyz",
                "fine"
        );

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

        List<String> input = Arrays.asList(
                "guarda",
                "vai est",
                "vai ovest",
                "fine"
        );

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        assertFalse(io.getOutput().isEmpty());
    }

    @Test
    public void testMovimentoMostraNuovaStanza() {

        List<String> input = Arrays.asList(
                "vai est",
                "guarda",
                "fine"
        );

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

        List<String> input = Arrays.asList(
                "vai sud",
                "prendi lanterna",
                "fine"
        );

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

        List<String> input = Arrays.asList(
                "vai sud",
                "prendi lanterna",
                "posa lanterna",
                "fine"
        );

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

        List<String> input = Arrays.asList(
                "fine"
        );

        IOSimulator io = new IOSimulator(input);
        DiaDia gioco = new DiaDia(io);

        gioco.gioca();

        assertTrue(true);
    }
}