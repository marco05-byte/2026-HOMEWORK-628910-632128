import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	@Test
	public void addAttrezzoTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 1);
		boolean risultato = b.addAttrezzo(a);
		assertTrue(risultato);
	}
	@Test
	public void hasAttrezzoTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 1);
		b.addAttrezzo(a);
		boolean ris1 = b.hasAttrezzo("Telecomando");
		boolean ris2 = b.hasAttrezzo("Martello");
		assertTrue(ris1);
		assertFalse(ris2);
	}
	@Test
	public void addPesoMaxDefaultTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 8);
		Attrezzo c = new Attrezzo("Martello", 3);
		assertTrue(b.addAttrezzo(a));
		assertFalse(b.addAttrezzo(c));
	}
	@Test
	public void addPesoMaxTest() {
		Borsa b = new Borsa(2);
		Attrezzo a = new Attrezzo("Telecomando", 5);
		assertFalse(b.addAttrezzo(a));
	}
	@Test
	public void getPesoMaxTest() {
		Borsa b = new Borsa(2);
		assertEquals(2, b.getPesoMax());
	}
	@Test
	public void getAttrezzoTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 1);
		b.addAttrezzo(a);
		assertEquals(a, b.getAttrezzo("Telecomando"));
	}
	@Test
	public void isEmptyTest() {
		Borsa b = new Borsa();
		assertTrue(b.isEmpty());
	}
//	Test generale valido per ADD, HAS, REMOVE.
	@Test 
	public void removeAttrezzoTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 1);
		boolean risultato = b.addAttrezzo(a);
		assertTrue(risultato);
		assertEquals(a, b.removeAttrezzo("Telecomando"));
		assertFalse(b.hasAttrezzo("Telecomando"));
		
	}
	@Test
	public void getPesoTest() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("Telecomando", 3);
		b.addAttrezzo(a);
		assertEquals(3, b.getPeso());
	}
	
}






