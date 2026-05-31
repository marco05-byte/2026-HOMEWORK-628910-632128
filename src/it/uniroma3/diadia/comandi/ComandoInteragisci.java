package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {

    @Override
    public void esegui(Partita partita) {

        AbstractPersonaggio p =
            partita.getStanzaCorrente().getPersonaggio();

        if (p != null) {
            io.mostraMessaggio(p.agisci(partita));
        } else {
            io.mostraMessaggio("Con chi dovrei interagire?");
        }
    }

    @Override
    public String getNome() {
        return "interagisci";
    }
}