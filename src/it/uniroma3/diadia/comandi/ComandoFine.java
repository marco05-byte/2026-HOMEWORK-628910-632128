package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private String parametro;
	private IO io;

	@Override
	public void setIO(IO io) {
	    this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
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
	        return "fine";
	    }
}
