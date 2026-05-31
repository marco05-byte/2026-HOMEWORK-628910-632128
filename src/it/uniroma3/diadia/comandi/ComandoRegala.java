package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

    @Override
    public void esegui(Partita partita) {

        AbstractPersonaggio p =
            partita.getStanzaCorrente().getPersonaggio();

        if (p == null) {
            io.mostraMessaggio("Non c'è nessuno a cui regalare nulla.");
            return;
        }

        String nomeAttrezzo = getParametro();

        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Specifica un attrezzo.");
            return;
        }

        Attrezzo attrezzo =
            partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

        if (attrezzo == null) {
            io.mostraMessaggio("Non hai questo attrezzo.");
            return;
        }

        partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

        io.mostraMessaggio(
            p.riceviRegalo(attrezzo, partita)
        );
    }

    @Override
    public String getNome() {
        return "regala";
    }
}