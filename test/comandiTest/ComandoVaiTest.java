package comandiTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza stanza1;
	private Stanza stanza2;
	
	@Test
	public void testVaiInDirezioneValida() {
		stanza1 = new Stanza("Stanza1");
		stanza2 = new Stanza("Stanza2");
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		partita = new Partita();
		partita.setStanzaCorrente(stanza1);
		ComandoVai comando = new ComandoVai();
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}
	@Test
	public void testVaiInDirezioneInsesistente() {
		stanza1 = new Stanza("Stanza1");
		partita = new Partita();
		partita.setStanzaCorrente(stanza1);
		ComandoVai comando = new ComandoVai();
		comando.setParametro("sud");
		comando.esegui(partita);
		assertEquals(stanza1, partita.getStanzaCorrente());
	}
}
