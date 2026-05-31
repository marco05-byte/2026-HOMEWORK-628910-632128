package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {

    public Strega(String nome, String presentazione) {
        super(nome, presentazione);
    }

    @Override
    public String agisci(Partita partita) {

        Stanza corrente = partita.getStanzaCorrente();

        Stanza scelta = null;

        if (!haSalutato()) {
            scelta = corrente.getStanzeAdiacenti().values()
                .stream()
                .min((a, b) -> a.getNumeroAttrezzi() - b.getNumeroAttrezzi())
                .orElse(corrente);
        } else {
            scelta = corrente.getStanzeAdiacenti().values()
                .stream()
                .max((a, b) -> a.getNumeroAttrezzi() - b.getNumeroAttrezzi())
                .orElse(corrente);
        }

        partita.setStanzaCorrente(scelta);

        return "La strega ti teletrasporta!";
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
        return "La strega ride e non accetta il regalo!";
    }
}