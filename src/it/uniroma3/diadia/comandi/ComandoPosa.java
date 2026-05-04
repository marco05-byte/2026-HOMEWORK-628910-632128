package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	private IO io;

	@Override
	public void setIO(IO io) {
	    this.io = io;
	}
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo==null) {
			io.mostraMessaggio("Non hai questo attrezzo");
			return;
		}
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		io.mostraMessaggio("Hai posato "+nomeAttrezzo);
	}
	 @Override
	    public String getParametro() {
	        return this.nomeAttrezzo;
	    }

	    @Override
	    public String getNome() {
	        return "posa";
	    }

}
