package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {

    private String nome;
    private String presentazione;
    private boolean haSalutato;

    public AbstractPersonaggio(String nome, String presentazione) {
        this.nome = nome;
        this.presentazione = presentazione;
        this.haSalutato = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean haSalutato() {
        return haSalutato;
    }

    public String saluta() {
        haSalutato = true;
        return "Ciao, io sono " + nome + ". " + presentazione;
    }

    public abstract String agisci(Partita partita);

    public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);

    @Override
    public String toString() {
        return nome;
    }
}