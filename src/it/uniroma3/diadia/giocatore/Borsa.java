package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.Configurazione;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
private Map<String, Attrezzo> attrezzi;
private int pesoMax;
public Borsa() {

}
public Borsa(int pesoMax) {
this.pesoMax = Configurazione.getPesoMassimoBorsa();
this.attrezzi = new HashMap<>();
}
public boolean addAttrezzo(Attrezzo attrezzo) {

    if (attrezzo == null)
        return false;

    if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
        return false;

    this.attrezzi.put(attrezzo.getNome(), attrezzo);

    return true;
}
public int getPesoMax() {
return pesoMax;
}
public Attrezzo getAttrezzo(String nomeAttrezzo) {
    return this.attrezzi.get(nomeAttrezzo);
}
public int getPeso() {
int peso = 0;
for (Attrezzo a : attrezzi.values())
peso += a.getPeso();
return peso;
}
public boolean isEmpty() {
    return this.attrezzi.isEmpty();
}
public boolean hasAttrezzo(String nomeAttrezzo) {
    return this.attrezzi.containsKey(nomeAttrezzo);
}



public Attrezzo removeAttrezzo(String nomeAttrezzo) {
    return this.attrezzi.remove(nomeAttrezzo);
}


public String toString() {

    return "Per nome: " + getContenutoOrdinatoPerNome()
            + "\nPer peso: " + getContenutoOrdinatoPerPeso()
            + "\nRaggruppati: " + getContenutoRaggruppatoPerPeso();
}

public List<Attrezzo> getContenutoOrdinatoPerPeso() {

    List<Attrezzo> ordinati = new ArrayList<>(this.attrezzi.values());

    Collections.sort(ordinati, new Comparator<Attrezzo>() {

        @Override
        public int compare(Attrezzo a1, Attrezzo a2) {

            int cmp = Integer.compare(a1.getPeso(), a2.getPeso());
            if (cmp != 0) return cmp;

            return a1.getNome().compareTo(a2.getNome());
        }
    });

    return ordinati;
}

public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {

    SortedSet<Attrezzo> ordinati =
        new TreeSet<>(new Comparator<Attrezzo>() {

        @Override
        public int compare(Attrezzo a1, Attrezzo a2) {
            return a1.getNome().compareTo(a2.getNome());
        }
    });

    ordinati.addAll(this.attrezzi.values());
    return ordinati;
}
public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {

    Map<Integer, Set<Attrezzo>> raggruppati = new TreeMap<>();

    for (Attrezzo attrezzo : this.attrezzi.values()) {

        int peso = attrezzo.getPeso();

        if (!raggruppati.containsKey(peso)) {
            raggruppati.put(peso, new HashSet<>());
        }

        raggruppati.get(peso).add(attrezzo);
    }

    return raggruppati;
}
public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {

    SortedSet<Attrezzo> ordinati =
            new TreeSet<>(new Comparator<Attrezzo>() {

        @Override
        public int compare(Attrezzo a1, Attrezzo a2) {

            if (a1.getPeso() != a2.getPeso()) {
                return a1.getPeso() - a2.getPeso();
            }

            return a1.getNome().compareTo(a2.getNome());
        }
    });

    ordinati.addAll(this.attrezzi.values());

    return ordinati;
}
}