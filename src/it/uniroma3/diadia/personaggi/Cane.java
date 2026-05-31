package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

    private String ciboPreferito;

    public Cane(String nome, String presentazione, String ciboPreferito) {
        super(nome, presentazione);
        this.ciboPreferito = ciboPreferito;
    }

    @Override
    public String agisci(Partita partita) {
        partita.getGiocatore().setCfu(
            partita.getGiocatore().getCfu() - 1
        );
        return "Il cane ti morde! Perdi 1 CFU.";
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

        if (attrezzo != null && attrezzo.getNome().equals(ciboPreferito)) {
            partita.getStanzaCorrente().addAttrezzo(attrezzo);
            return "Il cane accetta il cibo e lascia cadere un oggetto.";
        }

        partita.getGiocatore().setCfu(
            partita.getGiocatore().getCfu() - 1
        );

        return "Il cane rifiuta e ti morde! -1 CFU.";
    }
}
