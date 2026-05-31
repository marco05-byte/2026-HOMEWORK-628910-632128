import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;


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
	@Test
	public void testGetSortedSetOrdinatoPerPesoConStessoPeso() {

	    Borsa borsa = new Borsa();

	    Attrezzo libro = new Attrezzo("libro", 5);
	    Attrezzo ps = new Attrezzo("ps", 5);

	    borsa.addAttrezzo(libro);
	    borsa.addAttrezzo(ps);

	    SortedSet<Attrezzo> ordinati =
	            borsa.getSortedSetOrdinatoPerPeso();

	    assertEquals(2, ordinati.size());

	    assertTrue(ordinati.contains(libro));
	    assertTrue(ordinati.contains(ps));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {

	    Borsa borsa = new Borsa();

	    Attrezzo ps = new Attrezzo("ps", 3);
	    Attrezzo libro = new Attrezzo("libro", 3);
	    Attrezzo piuma = new Attrezzo("piuma", 1);

	    borsa.addAttrezzo(ps);
	    borsa.addAttrezzo(libro);
	    borsa.addAttrezzo(piuma);

	    List<Attrezzo> ordinati =
	            borsa.getContenutoOrdinatoPerPeso();

	    assertEquals(piuma, ordinati.get(0));
	    assertEquals(libro, ordinati.get(1));
	    assertEquals(ps, ordinati.get(2));
	}
	@Test
	public void testGetContenutoOrdinatoPerNome() {

	    Borsa borsa = new Borsa();

	    Attrezzo zaino = new Attrezzo("zaino", 1);
	    Attrezzo libro = new Attrezzo("libro", 8);

	    borsa.addAttrezzo(zaino);
	    borsa.addAttrezzo(libro);

	    SortedSet<Attrezzo> ordinati =
	            borsa.getContenutoOrdinatoPerNome();

	    Iterator<Attrezzo> it = ordinati.iterator();

	    assertEquals(libro, it.next());
	    assertEquals(zaino, it.next());
	}
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {

	    Borsa borsa = new Borsa();

	    Attrezzo libro = new Attrezzo("libro", 3);
	    Attrezzo ps = new Attrezzo("ps", 3);
	    Attrezzo piuma = new Attrezzo("piuma", 1);

	    borsa.addAttrezzo(libro);
	    borsa.addAttrezzo(ps);
	    borsa.addAttrezzo(piuma);

	    Map<Integer, Set<Attrezzo>> raggruppati =
	            borsa.getContenutoRaggruppatoPerPeso();

	    assertEquals(2, raggruppati.size());

	    assertTrue(raggruppati.get(3).contains(libro));
	    assertTrue(raggruppati.get(3).contains(ps));

	    assertTrue(raggruppati.get(1).contains(piuma));
	}
	
}






