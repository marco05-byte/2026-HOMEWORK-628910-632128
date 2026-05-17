package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private String parametro;
	private IO io;
	private static final String[] ELENCO_COMANDI = {
	        "vai", "prendi", "posa", "aiuto", "fine", "guarda"
	    };
	

	
	@Override
	public void setIO(IO io) {
	    this.io = io;
	}
	
	    @Override
	    public void esegui(Partita partita) {
	        io.mostraMessaggio("Comandi disponibili:");
	        for (String comando : ELENCO_COMANDI) {
	        	io.mostraMessaggio(comando);
	        }
	    }

	    @Override
	    public void setParametro(String parametro) {
	    	this.parametro=parametro;
	    }
	    @Override
	    public String getParametro() {
	        return this.parametro;
	    }

	    @Override
	    public String getNome() {
	        return "aiuto";
	    }

}
