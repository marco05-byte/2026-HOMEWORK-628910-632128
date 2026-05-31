package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

    private Attrezzo attrezzo;

    private static final String MSG_DONO =
        "Il mago ti dona un oggetto magico!";
    private static final String MSG_NO =
        "Non ho più nulla da darti.";

    public Mago(String nome, String presentazione, Attrezzo attrezzo) {
        super(nome, presentazione);
        this.attrezzo = attrezzo;
    }

    @Override
    public String agisci(Partita partita) {
        return riceviRegalo(null, partita);
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

        if (this.attrezzo != null) {
            partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
            this.attrezzo = null;
            return MSG_DONO;
        }

        return MSG_NO;
    }
}
