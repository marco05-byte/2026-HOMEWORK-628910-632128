package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IO io;

	@Override
	public void setIO(IO io) {
	    this.io = io;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi prendere?");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(attrezzo==null) {
			io.mostraMessaggio("Attrezzo non presente");
			return;
		}
		partita.getStanzaCorrente().removeAttrezzo(attrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		io.mostraMessaggio("Hai preso "+nomeAttrezzo);
	}
	 @Override
	    public String getParametro() {
	        return this.nomeAttrezzo;
	    }

	    @Override
	    public String getNome() {
	        return "prendi";
	    }
}
